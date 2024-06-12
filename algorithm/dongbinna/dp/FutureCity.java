import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FutureCity {


    static int N;   //회사 갯수
    static int M;   //회사 경로 개수
    static int X;   //방문 할 회사 번호
    static int K;   //중간에 방문 할 회사 번호
    static int[][] graph;
    static int INF = 100000000;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = 1;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken())-1;
        K = Integer.parseInt(st.nextToken())-1;

        floydWarshall();
        int result=graph[0][X]+graph[X][K];
        if(result>=INF){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    static void floydWarshall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
