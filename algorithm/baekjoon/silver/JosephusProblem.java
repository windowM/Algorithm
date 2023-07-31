import java.io.*;
import java.util.*;

public class JosePhusProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        LinkedList<Integer> numList = new LinkedList<>();

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            numList.offerLast(i);
        }

        sb.append("<");


        //배열에 한 요소만 남을 때 까지  반복 ("<")
        while(numList.size()!=1){
            //k마다 poll해야 하기에 앞에 값들을 뒤로 옮기는 작업
            for(int i=0;i<k-1;i++){
                numList.offerLast(numList.pollFirst());
            }
            sb.append(numList.pollFirst()+", ");
        }
        sb.append(numList.pollFirst()+">");

        System.out.println(sb);
    }
}