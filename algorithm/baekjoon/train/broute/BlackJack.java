import java.util.*;
import java.io.*;

public class BlackJack{

    static int N;
    static int M;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr=new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
    }

    public static int search(){
        int result = 0;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int sum=arr[i]+arr[j]+arr[k];
                    if(M==sum) {
                        return sum;
                    }
                    if( result < sum && M >sum){
                        result=sum;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(search());
    }

}