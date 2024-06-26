import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1504 {

    // 무방향, 임의로 주어진 두 정점을 반드시 지나야함

    static int N, E;
//    static int[][] map;
    static List<Edge>[] list;
    static boolean[] visit;
    static int[] dp;
    static final int INF=200000000;
    static class Edge{
        int to,w;
        Edge(int to,int w){
            this.to=to;
            this.w=w;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list=new LinkedList[N];

        for (int i = 0; i < N; i++) {
            list[i]=new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b,w));
            list[b].add(new Edge(a,w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        int a=dijkstra(0,v1);
        int b=dijkstra(v1,v2);
        int c=dijkstra(v2,N-1);
        int answer1= a+b+c;

        a=dijkstra(0,v2);
        b=dijkstra(v2,v1);
        c=dijkstra(v1,N-1);
        int answer2= a+b+c;

        int answer=Math.min(answer1,answer2);
        if(answer>=INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    static int dijkstra(int start,int end){
        visit=new boolean[N];
        dp=new int[N];
        Arrays.fill(dp,INF);
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{start,0});
        visit[start]=true;
        dp[start]=0;
        while(!pq.isEmpty()) {
            int[] arr=pq.poll();
            for (Edge edge : list[arr[0]]){
                if(dp[edge.to]>edge.w+arr[1]){
                    dp[edge.to]=edge.w+arr[1];
                    pq.offer(new int[]{edge.to,dp[edge.to]});
                }
            }
        }

        return dp[end];
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
