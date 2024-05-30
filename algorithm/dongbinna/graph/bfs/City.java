package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class City {

    static int N,M,K,X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visit;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        visit= new int[N+1];
        Arrays.fill(visit,-1);

        for(int i =0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            graph.get(y).add(x);
            graph.get(x).add(y);
        }
        bfs();
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        visit[X]=0;
        while(!queue.isEmpty()){
            int x = queue.poll();

            if(visit[x]>K) break;
            if(visit[x]==K) {
                System.out.println(x);
            }

            for(int i = 0 ; i<graph.get(x).size();i++) {
                if(visit[graph.get(x).get(i)]==-1) {
                    visit[graph.get(x).get(i)]=visit[x]+1;
                    queue.offer(graph.get(x).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
