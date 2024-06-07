import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11725 {

    static int N;
    static List<Integer>[] graph;
    static int[] answer;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        graph = new ArrayList[N+1];
        visit=new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1]=true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int a : graph[poll]) {
                if(visit[a]) continue;
                answer[a] = poll;
                q.offer(a);
                visit[a] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
