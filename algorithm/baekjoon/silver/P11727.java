import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727 {

    static int[] d;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        d=new int[1001];
        d[1]=1;
        d[2]=3;
        for(int i= 3; i<=N;i++){
            d[i]=(d[i-1]+d[i-2]*2)%10007;
        }
        System.out.println(d[N]);
    }
}
