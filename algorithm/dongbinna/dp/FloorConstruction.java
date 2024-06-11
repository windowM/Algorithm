import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorConstruction {

    static int[] d;

    static int dp(int x){
        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] !=0 ) return d[x];
        return d[x]=(dp(x-2)+ dp(x-1))%10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new int[N+1];
        System.out.println(dp(N));
    }
}
