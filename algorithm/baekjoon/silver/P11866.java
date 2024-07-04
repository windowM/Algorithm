import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<N;i++){
            q.offer(i+1);
        }
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i=0;i<K-1;i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        String str=sb.substring(0,sb.length()-2);
        sb=new StringBuilder(str).append(">");
        System.out.println(sb);

    }
}
