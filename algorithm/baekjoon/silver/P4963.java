import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963 {

    static int w,h;
    static int[][] graph;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static boolean[][] visit;
    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w= Integer.parseInt(st.nextToken());
            h= Integer.parseInt(st.nextToken());

            if(w==0&&h==0){
                break;
            }

            graph=new int[h][w];
            visit=new boolean[h][w];

            for(int i = 0 ;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j = 0;j<w;j++){
                    graph[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i =0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visit[i][j]&&graph[i][j]==1) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int y,int x){
        Queue<int[]> queue =new LinkedList<>();
        queue.offer(new int[]{x,y});
        visit[y][x]=true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i = 0 ;i<8;i++) {
                int nx = poll[0]+dx[i];
                int ny = poll[1]+dy[i];
                if(nx<0||ny<0||nx>=w||ny>=h||visit[ny][nx]) continue;
                if(graph[ny][nx]==0) continue;
                queue.offer(new int[]{nx,ny});
                visit[ny][nx]=true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
