import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1 = 익은 토마토
 * 0 = 익지 않은 토마토
 * -1 = 토마토가 들어있지 않는 칸
 */

public class P7576 {

    static int 가로,세로;
    static int[][] 그래프;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static int result=0;
    public static class 좌표{
        int x,y;

        public 좌표(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        가로 = Integer.parseInt(st.nextToken());
        세로 = Integer.parseInt(st.nextToken());

        그래프 = new int[세로][가로];
        for(int i = 0 ; i<세로; i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0 ; j<가로;j++){
                그래프[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }


    static void bfs(){
        Queue<좌표> 큐 = new LinkedList<>();

        for(int i =0;i<세로;i++){
            for(int j = 0 ;j<가로;j++){
                if(그래프[i][j]==1){
                    큐.offer(new 좌표(j,i));
                }
            }
        }

        while(!큐.isEmpty()){
            좌표 추출좌표 = 큐.poll();
            for(int i = 0 ; i<4;i++){
                int nx = 추출좌표.x+dx[i];
                int ny = 추출좌표.y+dy[i];
                if(nx<0||nx>=가로||ny<0||ny>=세로) continue;
                if(그래프[ny][nx]!=0) continue;
                그래프[ny][nx]=그래프[추출좌표.y][추출좌표.x]+1;
                큐.offer(new 좌표(nx,ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int maxNum = Integer.MIN_VALUE;
        for(int i=0;i<세로;i++){
            for(int j = 0;j<가로;j++){
                if(그래프[i][j]==0) {
                    result=-1;
                    System.out.println(result);
                    return;
                }
                if(maxNum<그래프[i][j])
                    maxNum=그래프[i][j];
            }
        }
        System.out.println(maxNum-1);
    }
}
