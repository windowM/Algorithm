import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1238 {
    static int N,M,X;
    static List<Edge>[] map;
    static List<Edge>[] reverseMap;

    static class Edge{
        int to, w;
        Edge(int to,int w){
            this.to=to;
            this.w=w;
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    //학생 수
        M = Integer.parseInt(st.nextToken());    //도로 개수
        X = Integer.parseInt(st.nextToken()) - 1;    //모일 마을

        map=new LinkedList[N];
        reverseMap=new LinkedList[N];

        for(int i=0;i<N;i++){
            map[i]=new LinkedList<>();
            reverseMap[i]=new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            map[a].add(new Edge(b,w));
            reverseMap[b].add(new Edge(a,w));
        }

        int[] rdist=dijkstra(reverseMap,X);
        int[] dist=dijkstra(map,X);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int n=rdist[i]+dist[i];
            max=Math.max(n,max);
        }
        System.out.println(max);
    }

    static int[] dijkstra(List<Edge>[] map,int start){
        boolean[] visit=new boolean[N];
        int[] dist=new int[N];
        Arrays.fill(dist,999999999);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{start,0});
        dist[start]=0;

        while(!pq.isEmpty()){
            int[] arr =pq.poll();
            if(visit[arr[0]]) continue;
            visit[arr[0]]=true;

            for(Edge edge:map[arr[0]]){
                if(dist[edge.to]>dist[arr[0]]+ edge.w){
                    dist[edge.to]=dist[arr[0]]+ edge.w;
                    pq.offer(new int[]{edge.to,dist[edge.to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
