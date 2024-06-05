import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {

    static int N;
    static char[][] graph;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    static void input() throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        N= Integer.parseInt(br.readLine());
        graph=new char[N][N];

        for(int i = 0 ; i<N;i++){
            String oneLine = br.readLine();
            graph[i]=oneLine.toCharArray();
        }

        visit=new boolean[N][N];
        int count = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(visit[i][j]) continue;
                bfs(j,i);
                count++;
            }
        }
        sb.append(count).append(" ");

        visit=new boolean[N][N];
        count=0;
        for(int i = 0; i<N;i++){
            for(int j = 0;j<N;j++){
                if(visit[i][j]) continue;
                bfs(j,i);
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

    static void bfs(int x, int y ){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visit[y][x]=true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();


            for(int i  = 0 ; i <4;i++){
                int nx = poll[0]+dx[i];
                int ny = poll[1]+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visit[ny][nx]) continue;
                if(graph[poll[1]][poll[0]]!=graph[ny][nx]) continue;
                queue.offer(new int[]{nx,ny});
                visit[ny][nx]=true;
            }

            if (graph[poll[1]][poll[0]] == 'G')
                graph[poll[1]][poll[0]]= 'R';
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
