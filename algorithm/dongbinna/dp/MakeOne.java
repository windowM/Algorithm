import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] arr = new int[30001];

        for(int i=2;i<=X;i++){
            arr[i]=arr[i-1]+1;
            if(i%2==0){
                arr[i]=Math.min(arr[i],arr[i/2]+1);
            }else if(i%3==0){
                arr[i]=Math.min(arr[i],arr[i/3]+1);
            }else if(i%5==0){
                arr[i]=Math.min(arr[i],arr[i/5]+1);
            }
        }
        System.out.println(arr[X]);
    }

}
