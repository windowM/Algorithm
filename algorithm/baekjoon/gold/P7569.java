import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {

    static int M,N,H;
    static int[][][] graph;
    static int[] dx={0,1,0,-1,0,0};
    static int[] dy={1,0,-1,0,0,0};
    static int[] dh={0,0,0,0,1,-1};

    static Queue<Pair> queue= new LinkedList<>();

    static class Pair{
        int x,y,z;

        Pair(int x, int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        // 가로, 세로, 높이
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        graph=new int[H][N][M];

        for(int i =0;i<H;i++){
            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k]==1) queue.offer(new Pair(k,j,i));
                }
            }
        }
        bfs();
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Pair pair = queue.poll();

            for(int i = 0 ;i<6;i++){
                int nx=pair.x+dx[i];
                int ny=pair.y+dy[i];
                int nz=pair.z+dh[i];

                if(nx<0||ny<0||nz<0||nx>=M||ny>=N||nz>=H) continue;
                if(graph[nz][ny][nx]!=0) continue;
                queue.offer(new Pair(nx,ny,nz));
                graph[nz][ny][nx]=graph[pair.z][pair.y][pair.x]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(graph[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    if(maxValue<graph[i][j][k]){
                        maxValue=graph[i][j][k];
                    }
                }
            }
        }
        System.out.println(maxValue-1);
    }
}
