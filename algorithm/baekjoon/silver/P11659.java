import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken()); //개수
        int M= Integer.parseInt(st.nextToken()); //횟수

        int[] arr=new int[N+1];
        st=new StringTokenizer(br.readLine());
        arr[0]= 0;
        for(int i=1;i<=N;i++){
            arr[i]= Integer.parseInt(st.nextToken())+arr[i-1];
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            System.out.println(arr[end]-arr[start-1]);
        }
    }
}
