import java.util.*;
import java.io.*;

public class DFS_BFS {

    static StringBuilder sb= new StringBuilder();

    static int N;
    static int M;
    static int S;

    static List<List<Integer>> graph;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visit=new boolean[N+1];

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

        for(int i=1;i<=N;i++){
            Collections.sort(graph.get(i));
        }

    }

    static void breadthFirstSearch(int s){

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visit[s]=true;
        sb.append(s+" ");

        while(!queue.isEmpty()){
            int num = queue.poll();

            for(int i=1;i<=graph.get(num).size();i++) {
                int nextV=graph.get(num).get(i-1);
                if (visit[nextV]) continue;
                queue.offer(nextV);
                visit[nextV]=true;
                sb.append(nextV+" ");
            }
        }

    }

    static void depthFirstSearch(int s){
        visit[s]=true;
        sb.append(s+" ");

        for(int i : graph.get(s)){
            if(visit[i]) continue;
            depthFirstSearch(i);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        depthFirstSearch(S);

        //방문기록 초기화
        visit=new boolean[N+1];
        sb.append("\n");

        breadthFirstSearch(S);

        System.out.println(sb);
    }

}
