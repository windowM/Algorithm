import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack=new Stack<>();
        int idx=1;
        for(int i=0;i<n;i++){
            if(arr[i]==idx){
                idx++;
            }else if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek()==idx){
                    while(!stack.isEmpty()&&stack.peek()==idx) {
                        idx++;
                        stack.pop();
                    }
                }
                stack.push(arr[i]);
            }
        }


        for(int i=0;i<stack.size();i++){
            if(idx==stack.peek()){
                idx++;
                stack.pop();
            }else{
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
