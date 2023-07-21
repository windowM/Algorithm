import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordReverse2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String str=br.readLine();

        Stack<Character> stack=new Stack<>();


        for(int i=0;i< str.length();i++){

            if(str.charAt(i)=='<'){

                //'<'앞에 문자가 입력된게 있는지 확인 후 있으면 출력
                if(!stack.isEmpty()){
                    int stackSize=stack.size();
                    for(int k=0;k<stackSize;k++){
                        sb.append(stack.pop());
                    }
                }
                //'<'안에 문자들을 바로바로 스트링빌더에 저장
                while(str.charAt(i)!='>'){
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append('>');
            }

            //공백을 만나면 이전에 stack에 저장된 값을 출력해고 뒤에 공백 저장
            else if(str.charAt(i)== ' '){
                int stackSize=stack.size();
                for(int k=0;k<stackSize;k++){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            else{
                stack.add(str.charAt(i));
            }

        }

        //프로그램을 끝내기 전 stack에 쌓인 값들 처리
        int stackSize=stack.size();
        for(int k=0;k<stackSize;k++){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
