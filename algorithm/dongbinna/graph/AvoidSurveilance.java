import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AvoidSurveilance {

    static int N;
    static int graph[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean check;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String str = st.nextToken();
                if (str.equals("X")) {
                    graph[i][j] = 0;
                } else if (str.equals("S")) {
                    graph[i][j] = 1;
                } else if (str.equals("T")) {
                    graph[i][j] = 2;
                }
            }
        }

        dfs_set_wall(0);
    }

    static void dfs_set_wall(int count) {
        if (count == 3) {
            if (bfs_teacher_search()) {
                check = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = -1;
                    dfs_set_wall(count + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static boolean bfs_teacher_search() {
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int[][] cloneMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            cloneMap[i] = graph[i].clone();
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx=pair.x;
                int ny=pair.y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    if (cloneMap[nx][ny] == -1) break;
                    if (cloneMap[nx][ny] == 1) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
