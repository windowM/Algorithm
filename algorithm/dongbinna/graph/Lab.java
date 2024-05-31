import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab {

    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] graph;
    static int N,M;
    static int maxCount=0;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        graph=new int[N][M];

        for(int i = 0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0 ;j<M;j++){
                graph[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        dfs_wall_set(0);
    }

    static void dfs_wall_set(int wallCount){
        if(wallCount==3){
            bfs_virus();
            return;
        }
        for(int i = 0 ;i<N;i++){
            for(int j = 0;j<M;j++){
                if(graph[i][j]==0){
                    graph[i][j]=1;
                    dfs_wall_set(wallCount+1);
                    graph[i][j]=0;
                }
            }
        }
    }

    static void bfs_virus(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<N;i++){
            for(int j = 0;j<M;j++){
                if(graph[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for(int i = 0 ; i<N;i++){
            copyMap[i]=graph[i].clone();
        }

        while(!queue.isEmpty()){
            int[] nd =queue.poll();
            for(int i = 0 ; i<4;i++){
                int nx=nd[0]+dx[i];
                int ny=nd[1]+dy[i];
                if(nx<0||nx>=N||ny<0||ny>=M) continue;
                if(copyMap[nx][ny]!=0) continue;
                copyMap[nx][ny]=2;
                queue.offer(new int[]{nx,ny});
            }
        }

        int count=0;
        for(int i = 0 ;i<N;i++){
            for(int j=0;j<M;j++){
                if( copyMap[i][j]==0){
                    count++;
                }
            }
        }

        findMaxCount(count);
    }

    static void findMaxCount(int count){
        maxCount = Math.max(maxCount, count);
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(maxCount);
    }
}
