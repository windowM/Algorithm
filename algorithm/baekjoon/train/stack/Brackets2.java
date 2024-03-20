import java.util.*;
import java.io.*;

public class Brackets2 {

    static int testCase;
    static Stack<Character> stack;
    static boolean ans;

    static final String OPEN="([{",END=")]}";
    public static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase= Integer.parseInt(br.readLine());

        for(int i = 0; i<testCase;i++){
            stack=new Stack<>();
            String oneLine = br.readLine();
            for(int j=0;j<oneLine.length();j++){
                char c = oneLine.charAt(j);
                if(OPEN.contains(String.valueOf(c))){
                    stack.push(c);
                }else{
                    if(stack.empty()) {
                        ans= false;
                        break;
                    }
                    if(OPEN.indexOf(stack.peek())!=END.indexOf(c)) {
                        ans= false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.empty()) ans=true;
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        sol();
    }
}
