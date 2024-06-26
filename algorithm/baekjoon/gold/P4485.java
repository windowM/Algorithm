import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class P4485 {


    //도둑루피 : 검정색 루피 = 소지 루피 감소
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int N;
    static int[][] map;
    static boolean[][] visit;

    static class Edge{
        int x,y, count;
        Edge(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int repeat=1;
        while(true){
            N= Integer.parseInt(br.readLine());
            if(N==0) return;

            map=new int[N][N];
            visit=new boolean[N][N];

            StringTokenizer st;
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }


            int answer = bfs();
            System.out.println("Problem "+repeat+++": "+ answer);
        }
    }

    public static int bfs(){
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->a.count-b.count);
        pq.offer(new Edge(0,0,map[0][0]));
        visit[0][0]=true;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(edge.x==N-1&&edge.y==N-1){
                return edge.count;
            }
            for(int i=0;i<4;i++) {
                int nx = edge.x+dx[i];
                int ny=edge.y+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visit[ny][nx]) continue;
                visit[ny][nx]=true;
                pq.offer(new Edge(nx,ny,edge.count+map[ny][nx]));

            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
