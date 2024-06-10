import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2458 {

    static int N,M;
    static int[][] graph;
    static int[] answer;
    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        graph=new int[N][N];
        answer=new int[N];
        for(int i = 0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken())-1;
            int tall = Integer.parseInt(st.nextToken())-1;
            graph[small][tall]=1;
        }

        floydWarshall();

        for(int i = 0 ;i<N;i++){
            int count=0;
            for(int j=0;j<N;j++){
                if(graph[i][j]==1||graph[j][i]==1){
                    count++;
                }
            }
            answer[i]=count;
        }
    }

    static void floydWarshall(){
        for(int i = 0 ; i<N;i++){
            for(int j=0;j<N;j++){
                for(int k =0;k<N;k++){
                    if(graph[j][i]==1&&graph[i][k]==1){
                        graph[j][k]=1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int a=0;
        for(int c:answer){
            if(c==N-1){
               a++;
            }
        }
        System.out.println(a);
    }
}
