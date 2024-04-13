import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2667 {
    static StringBuilder sb= new StringBuilder();
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    static int N;
    static String[] map;
    static boolean[][] isVisited;
    static ArrayList<Integer> answer = new ArrayList();
    static int groupCount = 0;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        map=new String[N];
        isVisited=new boolean[N][N];
        for(int i = 0 ; i<N;i++){
            map[i]=br.readLine();
        }
    }

    static void sol(){
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(map[i].charAt(j)=='1'&&!isVisited[i][j]){
                    groupCount =0;
                    dfs(i,j);
                    answer.add(groupCount);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append('\n');
        for(int cnt : answer) sb.append(cnt).append('\n');
        System.out.println(sb);
    }

    static void dfs(int x,int y){
        groupCount++;
        isVisited[x][y]=true;
        for(int i = 0 ;i<4;i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(map[nx].charAt(ny)=='0') continue;
            if(isVisited[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sol();
    }

}
