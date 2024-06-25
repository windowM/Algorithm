import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {

    static int N,M,START,TO;
    static List<Edge>[] map;
    static boolean[] visit;
    static int[] dist;
    static class Edge{
        int to,w;
        Edge(int to,int w){
            this.to=to;
            this.w=w;
        }
    }
    static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());

        map=new LinkedList[N];
        visit=new boolean[N];
        dist=new int[N];

        for(int i=0;i<N;i++){
            map[i]=new LinkedList<>();
            dist[i]=999999999;
        }
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken())-1;
            int b= Integer.parseInt(st.nextToken())-1;
            int w= Integer.parseInt(st.nextToken());

            map[a].add(new Edge(b,w));
            map[b].add(new Edge(a,w));
        }
        st=new StringTokenizer(br.readLine());
        START= Integer.parseInt(st.nextToken())-1;
        TO= Integer.parseInt(st.nextToken())-1;

        dijkstra(START);

        for(int i=0;i<N;i++){

        }
        System.out.println(dist[TO]);
    }
    static void dijkstra(int start){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.offer(new int[]{start,0});
        dist[start]=0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(visit[arr[0]]) continue;
            visit[arr[0]]=true;

            for(Edge edge:map[arr[0]]){
                if(dist[edge.to]>=arr[1]+edge.w){
                    dist[edge.to]=arr[1]+edge.w;
                    pq.offer(new int[]{edge.to,dist[edge.to]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
