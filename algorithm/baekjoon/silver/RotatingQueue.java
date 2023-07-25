import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


/**
 * 반환 타입이 true/false/null
 * 추가 : offerFirst
 * 삭제 : pollFirst
 * 조회 : peekFirst, get
 */

public class RotatingQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            count += getRotationCount(deque, target);
        }

        System.out.println(count);
    }

    private static int getRotationCount(LinkedList<Integer> deque, int target) {
        int count=0;
        int target_idx=deque.indexOf(target);
        int mid = deque.size()/2;

        while (true) {
            int front = deque.peekFirst();

            if (front == deque.get(target_idx)) {
                deque.pollFirst();
                return count;
            }
            else if(target_idx<=mid) {
                deque.offerLast(deque.pollFirst());
                count++;
            }
            else{
                deque.addFirst(deque.pollLast());
                count++;
            }
        }
    }
}