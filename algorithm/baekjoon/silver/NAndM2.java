import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class NAndM2 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static int[] select


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[M + 1];
        used = new int[N+1];
    }

    static void realFunc(int k) throws IOException {
        if (k == M + 1) {
            for (int i = 1; i < M + 1; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = select[k-1]+1; i <= N; i++) {
                select[k] = i;
                realFunc(k + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        realFunc(1);
        System.out.println(sb);
    }
}
