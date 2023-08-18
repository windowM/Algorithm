import java.util.*;
import java.io.*;

public class BFS1{

    static int N;
    static int M;

    static List<List<Integer>> graph;
    static int[] visited;

    public static int input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int s =Integer.parseInt(st.nextToken());

        graph=new ArrayList<>();
        visited=new int[N+1];

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList());
        }

        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for(int i = 1; i<=N;i++){
            Collections.sort(graph.get(i));
        }

        return s;
    }

    public static void bfsAlgorithm(int s){
        int cnt=1;

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(s);
        visited[s]=cnt++;

        while(!queue.isEmpty()){
            int num=queue.poll();

            for(int i=1;i<=graph.get(num).size();i++) {
                int nextV=graph.get(num).get(i-1);
                if (visited[nextV] != 0) continue;
                queue.offer(nextV);
                visited[nextV]=cnt++;
            }

        }
    }

    public static void main(String[] args) throws IOException{
        bfsAlgorithm(input());
        for(int i=1;i<=N;i++){
            System.out.println(visited[i]);
        }
    }

}