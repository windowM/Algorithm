import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class RightBigNo {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] M;
    static  Deque<Integer> deque;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        M = new int[N+1];
        deque =new ArrayDeque<>(N+1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            M[i]=(Integer.parseInt(st.nextToken()));
        }

    }

    static void realFunc(int k) throws IOException {

        for(int i=1;i<=N;i++){
            while(!deque.isEmpty() && M[deque.peek()]<M[i]){
                M[deque.pop()]=M[i];
            }
            deque.push(i);
        }

        while(!deque.isEmpty()) {
            M[deque.pop()] = -1;
        }

        for(int i=1;i<=N;i++){
            sb.append(M[i]).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        realFunc(1);
        System.out.println(sb);
    }
}
