import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class P1931 {

    //시작시간으로 내림차순
    //peek()값의 끝나는 시간이>next 끝나는 시간 (교체)
    //peek()끝나는 시간이<next 시작 시간이면 (삽입)
    //

    static class Node implements Comparable<Node>{
        int start,end;
        Node(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Node node2){
            if(start-node2.start>0){
                return 1;
            }else if(start-node2.start<0){
                return -1;
            }else{
                if(end-node2.end>0){
                    return 1;
                }else if(end-node2.end<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //회의 개수
        PriorityQueue<Node> pq=new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            pq.offer(new Node(start,end));
        }
        Stack<Node> stack=new Stack<>();

        for(int i=0;i<N;i++){
            Node poll = pq.poll();
            if(stack.isEmpty()) stack.add(poll);
            else{
                if(stack.peek().end>poll.end){
                    stack.pop();
                    stack.add(poll);
                }else if(stack.peek().end<=poll.start){
                    stack.add(poll);
                }
            }
        }

        System.out.println(stack.size());
    }
}
