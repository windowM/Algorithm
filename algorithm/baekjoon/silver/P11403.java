import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403 {

    static int N;
    static int[][] graph;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N= Integer.parseInt(br.readLine());
        graph=new int[N][N];

        for(int i = 0 ;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                graph[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();

        for(int i = 0 ;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void floydWarshall(){

        //거쳐 지나가는 노드
        for(int i = 0 ;i<N;i++){
            //출발 노드
            for(int j=0;j<N;j++){
                //도착 노드
                for(int k=0;k<N;k++){
                    if(graph[j][i]==1&&graph[i][k]==1){
                        graph[j][k]=1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
