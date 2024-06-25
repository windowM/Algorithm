import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13549 {

    //수빈 ,동생
    //x-1,x+1,순간이동(0초후 2*x)
    static int N,M;
    static boolean[] visit;
    static int[] dist;
    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        dist=new int[100001];
        Arrays.fill(dist,999999999);
        visit=new boolean[100001];
        dijkstra(N);
        System.out.println(dist[M]);
    }

//    static void bfs(){
//        Queue<int[]> q=new LinkedList<>();//0:위치, 1:count;
//        q.offer(new int[]{N,0});
//        while(!q.isEmpty()){
//            int[] poll = q.poll();
//            if(visit[poll[0]]) continue;
//            visit[poll[0]]=true;
//            if(poll[0]==M) {
//                System.out.println(poll[1]);
//                return;
//            }
//
//            if(poll[0]*2<=100000) {
//                q.offer(new int[]{poll[0]*2,poll[1]});
//            }
//            if(poll[0]-1>=0) {
//                q.offer(new int[]{poll[0] - 1, poll[1] + 1});
//            }
//            if(poll[0]+1<=100000) {
//                q.offer(new int[]{poll[0] + 1, poll[1] + 1});
//            }
//        }
//    }

    static void dijkstra(int start){
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{start,0});
        dist[start]=0;

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
//            if(visit[arr[0]]) continue;
//            visit[arr[0]] = true;

            int nx=arr[0]+1;
            int cost=arr[1]+1;
            if(nx<=100000&&dist[nx]>cost){
                dist[nx]=cost;
                pq.offer(new int[]{nx,cost});
            }

            nx=arr[0]-1;
            if(nx>=0&&dist[nx]>cost){
                dist[nx]=cost;
                pq.offer(new int[]{nx,cost});
            }

            nx = arr[0] * 2;
            if(nx<=100000&&dist[nx]>arr[1]) {
                dist[nx]=arr[1];
                pq.offer(new int[]{nx,arr[1]});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
