import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {

    static int N,M;
    static int[][] graph;
    static int INF = 100000000;

    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        graph=new int[N][N];

        for(int i = 0 ;i<M;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken())-1;
            int d= Integer.parseInt(st.nextToken())-1;
            int c= Integer.parseInt(st.nextToken());
            if(graph[s][d]!=0&&graph[s][d]<=c) continue;
            graph[s][d]=c;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(graph[i][j]==0) graph[i][j]=INF;
            }
        }

        floydWarshall();
    }

    static void floydWarshall(){
        for(int i = 0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(graph[j][k]>graph[j][i]+graph[i][k]){
                        graph[j][k]=graph[j][i]+graph[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb= new StringBuilder();
        for(int i = 0 ;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==INF) graph[i][j]=0;
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
