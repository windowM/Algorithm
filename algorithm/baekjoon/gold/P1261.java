import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1261 {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int M,N; //M:가로, N:세로
    static int[][] map;
    static boolean[][] visit;
    static int answer=Integer.MAX_VALUE;
    static class Node{
        int x ,y, wCount;
        Node(int x,int y, int wCount){
            this.x=x;
            this.y=y;
            this.wCount=wCount;
        }
    }
    static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());
        visit=new boolean[N][M];
        map=new int[N][M];
        for(int i=0;i<N;i++){
            String oneLine =br.readLine();
            for(int j=0;j<oneLine.length();j++){
                map[i][j]=oneLine.charAt(j)-'0';
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        PriorityQueue<Node> q=new PriorityQueue<>((a,b)->a.wCount-b.wCount);
        q.offer(new Node(0,0,0));
        visit[0][0]=true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0;i<4;i++) {
                int nx = node.x +dx[i];
                int ny=node.y+dy[i];

                if(nx==M-1&&ny==N-1){
                    return node.wCount;
                }

                if(nx<0||ny<0||nx>=M||ny>=N) continue;
                if (visit[ny][nx]) continue;
                visit[ny][nx]=true;
                if(map[ny][nx]==1){
                    q.offer(new Node(nx,ny, node.wCount+1));
                }else{
                    q.offer(new Node(nx,ny, node.wCount));
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        input();
    }


}
