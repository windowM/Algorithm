import java.util.*;
import java.io.*;

public class Virus{

    static int N;
    static int M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int cnt=0;


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        visited=new boolean[N+1];

        graph=new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue=new LinkedList();
        queue.offer(start);
        visited[start]=true;

        while(!queue.isEmpty()){
            int num=queue.poll();
            for(int i=1; i<=graph.get(num).size();i++){
                int nextV=graph.get(num).get(i-1);
                if(visited[nextV]) continue;
                cnt++;
                queue.offer(nextV);
                visited[nextV]=true;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
    }
}