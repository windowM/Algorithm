import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            Stack<Character> st=new Stack<>();
            String str=br.readLine();
            for(char c:str.toCharArray()){
                if(st.isEmpty()){
                    st.push(c);
                }else if(st.peek()=='('&&c==')'){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
            if(st.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
