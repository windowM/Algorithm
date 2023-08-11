import java.util.*;
import java.io.*;

/**
 *  1. A~B 각각 소인수 분해
 *  2. count를 통해 구한 소수의 길이 check
 *  3. 해당 값의 count 개수를 소수인지 확인하는 메소드를 통해 확인
 *  4. 맞다면 ans+1;
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int A;
    static int B;


    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

    }

    static void realFunc() throws IOException {

        int ans=0;

        int count;

        //A이상 B이하 반복
        for(int i=A;i<=B;i++) {

            //소인수 분해 과정에서 원본 값을 해치기에 임시 저장
            int tempA=i;

            //소수의 개수 구하는 count
            count=0;

            //소인수 분해
            for (int j = 2; j <= Math.sqrt(i); j++) {
                while((tempA%j)==0){
                    count++;
                    tempA/=j;
                }
            }

            if(tempA!=1){
                count++;
            }

            //count가 2이상이면 소수인지 확인
            if(count>1) {

                boolean ck=true;

                //소수 확인인
                for (int j = 2;j <= Math.sqrt(count); j++) {
                    if (count % j == 0) {
                        ck = false;
                    }
                }

                if (ck) {
                    ans++;
                }
            }

        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws IOException {
        input();
        realFunc();

    }
}
