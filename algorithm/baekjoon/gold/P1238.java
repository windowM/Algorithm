import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1238 {
    //N명 학생
    // X번 마을 에 모여
    // M 개의 단방향 도로
    // i번째 길이를 지나는데 Ti시간 소비
    // N명의 학생 중 누가 가장 많은 시간을 소비하냐

    static int N,M,X;
//    static List<Edge> map;
    static int[][] map;
    static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());    //학생 수
        M= Integer.parseInt(st.nextToken());    //도로 개수
        X= Integer.parseInt(st.nextToken())-1;    //모일 마을
        map=new int[N][N];
        for(int i=0;i<N;i++) {
            Arrays.fill(map[i], 999999999);
            map[i][i]=0;
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken())-1;
            int b= Integer.parseInt(st.nextToken())-1;
            int w= Integer.parseInt(st.nextToken());
            map[a][b]=w;
        }
        floydwarshall();

        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max=Math.max(max,map[i][X]+map[X][i]);
        }
        System.out.println(max);
    }

    static void floydwarshall(){

        //거칠 노드
        for(int i=0;i<N;i++){
            //시작 노드
            for(int j=0;j<N;j++){
                //종료 노드
                for(int k=0;k<N;k++){
                    if(map[j][k]>map[j][i]+map[i][k]){
                        map[j][k]=map[j][i]+map[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
