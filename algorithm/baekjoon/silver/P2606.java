import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2606 {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visit;
    static int count = 0;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        graph=new int[N+1][N+1];
        visit=new boolean[N+1];

        StringTokenizer st;
        for(int i = 1 ; i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            graph[x][y]=1;
            graph[y][x]=1;
        }
        dfs(1);
    }

    static void dfs(int idx){
        visit[idx]=true;
        for(int i =  1 ;i<=N;i++){
            if(!visit[i]&&graph[idx][i]==1){
                dfs(i);
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(count);
    }
}

