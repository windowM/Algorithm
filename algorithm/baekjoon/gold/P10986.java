//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class P10986 {
//
//    //N 개의 수
//    //a1~an 연속된 구간합이 M으로 나눠 떠어지ㅡㄴㄴ 구간 개수
//    //
//    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(br.readLine());
//        int N= Integer.parseInt(st.nextToken());
//        int M= Integer.parseInt(st.nextToken());
//        int[] arr=new int[N];
//        st=new StringTokenizer(br.readLine());
//        for(int i=0;i<N;i++){
//            arr[i]= Integer.parseInt(st.nextToken());
//        }
//        int end=0;
//        int sum=0;
//        int answer=0;
//        for(int start=0;start<N;start++){
////            end=start;
//            while(end<N&&){
//                sum+=arr[end];
//                end++;
//                if(sum%M==0){
//                    answer++;
//                }
//            }
//        }
//
//    }
//}
