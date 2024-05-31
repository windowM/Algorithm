package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Infection {

    static int N, M, S, TX, TY;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static class Pair implements Comparable<Pair> {
        int x, y, virus, s;

        public Pair(int x, int y, int virus, int s) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.s = s;

        }

        @Override
        public int compareTo(Pair o){
            return Integer.compare(this.virus,o.virus);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        TX = Integer.parseInt(st.nextToken()) - 1;
        TY = Integer.parseInt(st.nextToken()) - 1;

        bfs();
    }

    static void bfs() {
        Queue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    queue.offer(new Pair(i, j, graph[i][j], 0));
                }
            }
        }

        Queue<Pair> queue1 = new LinkedList<>();
        while (!queue.isEmpty()) {
            queue1.offer(queue.poll());
        }

        while (!queue1.isEmpty()) {
            Pair pair = queue1.poll();

            if (pair.s == S) {
                System.out.println(graph[TX][TY]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (graph[nx][ny] != 0) continue;
                graph[nx][ny] = graph[pair.x][pair.y];
                queue1.offer(new Pair(nx, ny, graph[nx][ny], pair.s + 1));
            }
        }
        System.out.println(graph[TX][TY]);
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
