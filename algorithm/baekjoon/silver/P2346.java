import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2346 {

    //풍선안에 종이 -N~N정수 존재
    //1번 풍선 터트린 후 종이에 값만큼 이동하여 터트림
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        Deque<int[]> dq=new ArrayDeque<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num= Integer.parseInt(st.nextToken());
            dq.offer(new int[]{i+1,num});
        }

        int[] poll=dq.poll();
        sb.append(poll[0]+" ");

        while(!dq.isEmpty()){
            if(poll[1]>0){
                for(int i=0;i<poll[1]-1;i++) {
                    dq.addLast(dq.removeFirst());
                }
                poll=dq.poll();
            }else{
                for(int i=poll[1]+1;i<0;i++){
                    dq.addFirst(dq.removeLast());
                }
                poll=dq.removeLast();
            }
            if(dq.isEmpty()){
                sb.append(poll[0]);
            }else{
                sb.append(poll[0]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
