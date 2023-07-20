import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrinterQueue{
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Deque<int[]> queue=new ArrayDeque<>();

        int count;
        int repeat= Integer.parseInt(br.readLine());

        while(repeat>0){
            count=0;
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken()); //m의 중요도를 기준으로

            st=new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                int[] pair = new int[] {i, Integer.parseInt(st.nextToken())};
                queue.addFirst(pair);
            }

            for(int i=0;i<n;i++){
                int[] peekNum = queue.removeLast();

                for(int[] a : queue) {
                    System.out.println(peekNum[1] +"<"+a[1]);
                    if (peekNum[1] < a[1]) {
                        queue.addFirst(peekNum);
                        break;
                    }
                }

            }

//           sb.append().append('\n');
            repeat--;
        }
    }
}