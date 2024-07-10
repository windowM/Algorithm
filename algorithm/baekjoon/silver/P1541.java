import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(),"-");
        int answer=Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            StringTokenizer st2=new StringTokenizer(st.nextToken(),"+");
            int temp=0;
            while(st2.hasMoreTokens()){
                int a= Integer.parseInt(st2.nextToken());
                temp+=a;
            }
            if(answer==Integer.MAX_VALUE){
                answer=temp;
            }else{
                answer-=temp;
            }
        }
        System.out.println(answer);
    }
}
