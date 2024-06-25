import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1504 {

    // 무방향, 임의로 주어진 두 정점을 반드시 지나야함

    static int N, E;
    static int[][] map;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 200000000);
            map[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = w;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        floydWarshall();

        long result1 = map[0][v1] + map[v1][v2] + map[v2][N - 1];
        long result2 = map[0][v2] + map[v2][v1] + map[v1][N - 1];

        // 이게 무슨 조건이냐
        if (v1 == 0 || v1 == 0) {
            if (v1 == N - 1 || v2 == N - 1) {
                if (map[0][N - 1] >= 200000000) {
                    System.out.println("-1");
                } else {
                    System.out.println(map[0][N - 1]);
                }
            }
        }else if (result1 >= 200000000 || result2 >= 200000000) {
            System.out.println("-1");
        } else {
            System.out.println(Math.min(result1, result2));
        }


    }

    static void floydWarshall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
