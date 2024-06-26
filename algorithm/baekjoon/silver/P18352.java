import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18352 {
    static int N,M,K,X;
    static List<Integer>[] map;
    static boolean[] visit;
    static List<Integer> answer;

    static void input() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        X= Integer.parseInt(st.nextToken())-1;

        map=new LinkedList[N];
        visit=new boolean[N];
        answer=new LinkedList<>();
        for(int i=0;i<N;i++){
            map[i]=new LinkedList<>();
        }

        for(int i=0;i<M;i++){
            String[] sArr=br.readLine().split(" ");
            int a=Integer.parseInt(sArr[0])-1;
            int b=Integer.parseInt(sArr[1])-1;
            map[a].add(b);
        }

        bfs(X);

        if(answer.size()==0){
            System.out.println("-1");
        }else{
            Collections.sort(answer);
            for(int i: answer){
                System.out.println(i);
            }
        }
    }

    static void bfs(int start){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{start,0});
        visit[start]=true;

        while(!q.isEmpty()){
            int[] arr=q.poll();
            if(arr[1]==K){
                answer.add(arr[0]+1);
            }
            for(int n:map[arr[0]]){
                if(visit[n]) continue;
                visit[n]=true;
                q.offer(new int[]{n,arr[1]+1});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
