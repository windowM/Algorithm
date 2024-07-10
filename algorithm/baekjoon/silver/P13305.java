import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {
    //주유소 리터당 가격
    //도로길이
    //N=10만 => 완전탐색은 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine()); //도시 개수
        StringTokenizer st=new StringTokenizer(br.readLine()); //도로 길이
        long[] road=new long[N-1];
        for(int i=0;i<N-1;i++){
            road[i]= Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        long[] oil=new long[N];
        for(int i=0;i<N;i++){
            oil[i]= Integer.parseInt(st.nextToken());
        }

        long answer=road[0]*oil[0];
        int oilIdx=0;
        for(int i=1;i<N-1;i++){
            if(road[i]*oil[oilIdx]>road[i]*oil[i]){
                answer+=road[i]*oil[i];
                oilIdx=i;
            }else{
                answer+=road[i]*oil[oilIdx];
            }
        }
        System.out.println(answer);
    }
}
