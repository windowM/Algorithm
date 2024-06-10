import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389 {


    static  int N,M;
    static int[][] graph;
    static int minValue=Integer.MAX_VALUE;
    static int answer;
    static void input() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        graph=new int[N][N];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st. nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            graph[x][y]=1;
            graph[y][x]=1;
        }

        for(int i = 0 ;i<N;i++){
            for(int j = 0;j<N;j++){
                if(i==j) continue;
                if(graph[i][j]==0) {
                    graph[i][j] = 100000000;
                }
            }
        }

        floydWarshall();
        calcAnswer();
    }

    static void floydWarshall(){
        //거칠 노드
        for(int i = 0 ;i<N;i++){
            //시작 노드
            for(int j = 0;j<N;j++){
                // 도착 노드
                for(int k = 0;k<N;k++){
                    if(graph[j][k]>graph[j][i]+graph[i][k]){
                        graph[j][k]=graph[j][i]+graph[i][k];
                    }
                }
            }
        }
    }

    static void calcAnswer(){

        for(int i = 0 ;i<N;i++){
            int num=0;
            for(int j=0;j<N;j++) {
                num += graph[i][j];
            }

            if(minValue>num){
                minValue=num;
                answer=i+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(answer);
    }
}
