import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[][] dp=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                dp[i][j]= Integer.parseInt(st.nextToken())+dp[i][j-1];
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            int answer=0;
            st=new StringTokenizer(br.readLine());
            int x1= Integer.parseInt(st.nextToken()); //1
            int y1= Integer.parseInt(st.nextToken()); //2
            int x2= Integer.parseInt(st.nextToken()); //1
            int y2= Integer.parseInt(st.nextToken()); //2

            for(int j=x1;j<=x2;j++){
                answer+=(dp[j][y2]-dp[j][y1-1]);
            }
            sb.append(answer + "\n");

        }
        System.out.println(sb);

    }
}
