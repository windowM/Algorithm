import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class P14889 {

    //축구하기 위해 모인 사람 N
    //N/2명으로 스타트&링크팀
    static int N;
    static int[][] map;
    static boolean[] isPick;
    static int answer =Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        map=new int[N][N];
        isPick=new boolean[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        //N/2개를 픽하고 N[i][j]
        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int idx,int cnt){
        if(cnt==N/2){
            dif();
            return;
        }
        for(int i=idx;i<N;i++){
            if(isPick[i]) continue;
            isPick[i]=true;
            dfs(i+1,cnt+1);
            isPick[i]=false;
        }
    }

    static void dif(){
        int num=0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(isPick[i]&&isPick[j]){
                    num+=map[i][j]+map[j][i];
                }else if(!isPick[i]&&!isPick[j]){
                    num-=(map[i][j]+map[j][i]);
                }
            }
        }

        answer=Math.min(answer,Math.abs(num));
    }
}
