import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


/**
 *  1.자릿수가 다르면 0
 *  2.N에 8이 몇개 있는지 알아야함.
 *  3.같은 자리에 M에 8이 있는지도 고려 해야함...
 *
 *  -> String 타입으로 받아서 charAt()을 통해 하나씩 비교해야 겠다!
 *
 */
public class Eight {

    //    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String L;
    static String R;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        L= st.nextToken();
        R =st.nextToken();
    }

    static void realFunc() throws IOException {

        int count =0;

        /**
            문자열 길이가 다른 경우 = 0
            그외, L,R 각 자리 수가 같은지 비교
            다르면, 탈출
            같으면, 그 숫자가 8인지 확인 후 +1
         */

        if(L.length()==R.length()) {
            for(int i=0;i<L.length();i++){
                if(L.charAt(i)!=R.charAt(i)){
                    break;
                }else if(L.charAt(i)=='8') {
                    count++;
                }
            }
        }

        //숫자만 담으니 깨진다...
        bw.write(count+"\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        realFunc();

        bw.flush();
        bw.close();

    }
}
