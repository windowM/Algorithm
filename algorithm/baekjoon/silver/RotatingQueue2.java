import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


/**
 * 반환 타입이 true/false/null
 * 추가 : offerFirst
 * 삭제 : pollFirst
 */

public class RotatingQueue2 {

    public static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());

        int cnt=0;

        /**
         * firstNum : deque에 들어있는 첫 번째 값 추출
         * target : 정답 데이터중 1개
         *
         * while() : 내가 찾을 target과 첫 번째 값이 일치하면 탈출
         * 1. 맨 앞에 값을 맨 뒤로 보낸다
         * 2. 첫 번째 값을 뽑고 cnt 1증가
         * -> 왼쪽으로 밀면서 내가 찾는 값이 왼쪽으로 부터 몇번째 있는지 알 수 있다.
         *
         * Math.min(cnt,deque.size()+1-cnt)
         * -> 왼쪽으로 이동했을 경우와 오른쪽으로 이동한 경우의 최소 값을 추출
         */

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int firstNum=deque.pollFirst();
            cnt=0;
            while(firstNum != target){
                deque.addLast(firstNum);
                firstNum=deque.pollFirst();
                cnt++;
            }
            count+=Math.min(cnt,deque.size()+1-cnt);
        }

        System.out.println(count);

        br.close();
    }

}