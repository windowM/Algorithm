import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {

    static int C,N;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx={1,2,2,1,-1,-2,-2,-1};
    static int[] dy={2,1,-1,-2,-2,-1,1,2};

    static int cx,cy;
    static int tx,ty;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C= Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int c=0;c<C;c++) {
            N = Integer.parseInt(br.readLine());
            graph=new int[N][N];
            visit=new boolean[N][N];

            st=new StringTokenizer(br.readLine());
            cx= Integer.parseInt(st.nextToken());
            cy= Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            tx= Integer.parseInt(st.nextToken());
            ty= Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(graph[ty][tx]);
        }
    }

    static void bfs(){
        Queue<int[]> q =new LinkedList<>();
        q.offer(new int[]{cx,cy});
        visit[cy][cx]=true;

        while(!q.isEmpty()){
            int[] poll = q.poll();

            for(int i = 0;i<8;i++){
                int nx=poll[0]+dx[i];
                int ny=poll[1]+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N||visit[ny][nx]) continue;
                q.offer(new int[]{nx,ny});
                graph[ny][nx]=graph[poll[1]][poll[0]]+1;
                visit[ny][nx]=true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
