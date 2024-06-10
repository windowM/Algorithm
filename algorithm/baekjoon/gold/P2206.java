import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {

    static int N,M;
    static int[][] graph;
    static boolean[][][] visit;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int answer=-1;

    static class Pair{
        int x,y,level;
        boolean isBreak;
        Pair(int x,int y, int level, boolean isBreak){
            this.x=x;
            this.y=y;
            this.level=level;
            this.isBreak=isBreak;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        graph=new int[N][M];
        visit=new boolean[N][M][2];

        for(int i = 0 ;i<N;i++){
            String oneLine = br.readLine();
            for(int j = 0;j<M;j++){
                graph[i][j]=Character.getNumericValue(oneLine.charAt(j));
            }
        }

        bfs();

        System.out.println(answer);

    }

    static void bfs(){
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(0,0,1,false));
        visit[0][0][0]=true;

        while(!queue.isEmpty()){
            Pair poll = queue.poll();

            if(poll.x==M-1&&poll.y==N-1) {
                answer=poll.level;
                return;
            }

            for(int i = 0; i<4;i++){
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];

                if(nx<0||ny<0||nx>=M||ny>=N) continue;

                if(poll.isBreak){
                    if(graph[ny][nx]==0&&!visit[ny][nx][1]){
                        visit[ny][nx][1]=true;
                        queue.offer(new Pair(nx,ny,poll.level+1,true));
                    }
                }else{
                    if(graph[ny][nx]==1){
                        visit[ny][nx][1]=true;
                        queue.offer(new Pair(nx,ny, poll.level+1, true));
                    }else if(!visit[ny][nx][0]){
                        visit[ny][nx][0]=true;
                        queue.offer(new Pair(nx,ny,poll.level+1,false));
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
