import java.util.*;
import java.io.*;

public class Josephus {

    static StringBuilder sb;
    static int testCase;
    static int n;
    static int k;
    static List<Integer> arr;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase= Integer.parseInt(br.readLine());
        for(int i = 0; i<testCase ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr= new LinkedList<>();
            sb = new StringBuilder();

            for(int j=1;j<=n;j++){
                arr.add(j);
            }

            sol();
        }
    }

    public static void sol(){
        int idx = 0;
        while(arr.size()!=2){
            arr.remove(idx);
            idx+=k-1;
            if(idx>=arr.size()){
                idx-=arr.size();
            }
        }

        for(int num : arr){
            sb.append(num+" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
