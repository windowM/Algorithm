import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n= Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String type= st.nextToken();
            try {
                switch (type) {
                    case "push":
                        int num = Integer.parseInt(st.nextToken());
                        stack.add(num);
                        break;

                    case "pop":
                        System.out.println(stack.pop());
                        break;

                    case "size":
                        System.out.println(stack.size());
                        break;

                    case "empty":
                        if (stack.empty()) System.out.println(1);
                        else System.out.println(0);
                        break;

                    case "top":
                        System.out.println(stack.peek());
                        break;

                }
            }

            //pop, top의 경우 스택이 비어있다면 에러 반환
            //해당 에러에 대해 -1을 출력
            catch(Exception e){
                System.out.println(-1);
            }
        }

    }
}
