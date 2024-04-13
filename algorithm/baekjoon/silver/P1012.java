import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1012 {
    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static StringBuilder sb = new StringBuilder();
    static int count;
    static ArrayList<Integer> answer;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());
        for(int t = 0 ;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            isVisited = new boolean[M][N];
            answer= new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            sol();
        }
    }
    static void sol(){
        for(int i = 0; i<M;i++){
            for(int j =0;j<N;j++){
                if(!isVisited[i][j]&&map[i][j]==1){
                    count=0;
                    dfs(i,j);
                    answer.add(count);
                }
            }
        }
        System.out.println(answer.size());
    }

    static void dfs(int x, int y){
        count++;
        isVisited[x][y]=true;
        for(int i = 0 ; i<4;i++){
            int nx = x+dir[i][0];
            int ny =  y+ dir[i][1];
            if(nx<0||nx>=M||ny<0||ny>=N) continue;
            if(isVisited[nx][ny]) continue;
            if(map[nx][ny]==0) continue;
            dfs(nx,ny);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
