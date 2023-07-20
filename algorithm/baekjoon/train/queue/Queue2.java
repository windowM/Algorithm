import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        //queue는 마직막 값을 조회하는 메소드가 없기에, 이런 상황에 Deque를 사용하는 것이 좋을거 같다.
        Queue queue=new LinkedList();

        int n=Integer.parseInt(br.readLine());

        //가장 마지막에 들어간 숫자를 기록하기 위한 변수
        int last =9999;

        while(n-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    int num= Integer.parseInt(st.nextToken());
                    last=num;
                    queue.add(num);
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(last).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }
}
