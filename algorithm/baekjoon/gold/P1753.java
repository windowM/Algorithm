import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {

    static int V, E, K;
    static List<Edge>[] graph;
    static int[] dist;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[V];
        dist = new int[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }
        dijkstra(K);
    }

    static void dijkstra(int start) {
        // 1번째 값 = 가중치 , 2번째 값 = 노드
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visit = new boolean[V];
        priorityQueue.offer(new int[]{0, start});
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            // curr[0] = 가중치, curr[1] = 노드
            int[] curr = priorityQueue.poll();

            if (visit[curr[1]]) continue;
            visit[curr[1]] = true;

            for (Edge edge : graph[curr[1]]) {
                if (dist[edge.to] > dist[curr[1]] + edge.weight) {
                    dist[edge.to] = dist[curr[1]] + edge.weight;
                    priorityQueue.offer(new int[]{dist[edge.to], edge.to});
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < V; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

}
