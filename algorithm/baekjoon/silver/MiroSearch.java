import java.util.*;
import java.io.*;


/**
 *  1. DFS vs BFS -> "최소칸 수 " BFS
 *  2.
 */
public class Main {

    static int N;
    static int M;

    static int[][] graph;
    static boolean[][] visit;

    static int[] dx = {-1,1,0,0}; //상,하
    static int[] dy = {0,0,-1,1}; //좌,우


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph=new int[N+1][M+1];
        visit=new boolean[N+1][M+1];


        for(int i=1;i<=N;i++){
            String str = br.readLine();
            for(int j=1;j<=M;j++){
                graph[i][j]=(str.charAt(j-1)-'0');
            }
        }

    }

    static void breadthFirstSearch(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1});

        //초기 방문 처리
        visit[1][1] =true;

        while(!queue.isEmpty()){
            //현재 위치 뽑기
            int now[] = queue.poll();
            int x=now[0];
            int y=now[1];

            //상,하,좌,우 따지기
            for(int i=1;i<=4;i++) {
                int nextX=x+dx[i-1];
                int nextY=y+dy[i-1];

                //장외 처리
                if (nextX < 1 || nextY < 1 || nextX >N || nextY>M) continue;
                if (visit[nextX][nextY] || graph[nextX][nextY] == 0 ) continue;

                //다음 위치를 queue에 저장 및 방문 처리
                queue.offer(new int[]{nextX,nextY});
                graph[nextX][nextY]=graph[x][y]+1;
                visit[nextX][nextY] =true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        breadthFirstSearch();
        System.out.println(graph[N][M]);
    }

}
