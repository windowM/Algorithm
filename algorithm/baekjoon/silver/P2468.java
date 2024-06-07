import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    static int N;
    static int[][] graph;
    static boolean[][] visit;
    static int answer = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int maxNum=1;

    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        graph =new int[N][N];

        StringTokenizer st;
        for(int i =  0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                int num=Integer.parseInt(st.nextToken());
                graph[i][j]= num;
                if(maxNum<num) maxNum=num;
            }
        }


        for(int s = 0 ;s<=maxNum;s++) {
            visit = new boolean[N][N];
            changeMap(s);

            int count=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] != -1&&!visit[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            if(answer<count) answer=count;
        }
    }

    static void changeMap(int n){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(graph[i][j]<=(n)&& graph[i][j]!=-1){
                    graph[i][j]=-1;
                }
            }
        }
    }

    static void bfs(int y,int x ){
        Queue<int[]> queue =new LinkedList<>();
        queue.offer(new int[]{x,y});
        visit[y][x]=true;
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            for(int i = 0 ;i<4;i++) {
                int nx = q[0] + dx[i];
                int ny = q[1]+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N||visit[ny][nx]) continue;
                if(graph[ny][nx]==-1) continue;
                queue.offer(new int[]{nx,ny});
                visit[ny][nx]=true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(answer);
    }
}
