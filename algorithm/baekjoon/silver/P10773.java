import java.util.Scanner;
import java.util.Stack;

public class P10773 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<K;i++){
            int n=sc.nextInt();
            if(n==0 &&!st.isEmpty()) st.pop();
            else st.push(n);
        }

        int answer=0;
        for(int i:st){
            answer+=i;
        }
        System.out.println(answer);
    }
}
