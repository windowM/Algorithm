import java.io.*;
import java.util.*;

public class NAndM{

    static StringBuilder sb=new StringBuilder();

    static int[] selected;
    static int N;
    static int M;

    static void input() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        selected = new int[M+1];
    }

    static void rec_func(int k){
        if(k==M+1){
            // 모두 골랐을 때 기능
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(' ');
            }

            sb.append('\n');
        }else{
            for(int cand = 1; cand<=N;cand++){
                selected[k]=cand;
                //k+1 ~ M까지 모두 탐색
                rec_func(k+1);
                selected[k]=0;
            }

        }
    }

    public static void main(String[] args) throws IOException{
        input();
        rec_func(1);
        System.out.println(sb);
    }
}