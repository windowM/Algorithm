import java.util.*;
import java.io.*;


public class StandInLine{


    static StringBuilder sb=new StringBuilder();

    static int N;
    static int[] arr;

    //index를 사용해 원하는 위치에 값을 넣기 위함
    static ArrayList<Integer> ans = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        //배열 크기 N만큼 할당
        arr=new int[N+1];

        //1~N의 순서 저장
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }

    static void realFunc(){
        //역순으로 왼쪽에 사람이 있는 수 만큼 떨어진 위치에 i값 넣기
        for(int i=N;i>0;i--){
            ans.add(arr[i],i);
        }

        for(Integer in : ans){
            sb.append(in + " ");
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        realFunc();
        System.out.println(sb);
    }
}