package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Operation {

    static int N;
    static int[] A;
    static int[] operations;
    static int maxValue= Integer.MIN_VALUE;
    static int minValue= Integer.MAX_VALUE;

    static void input() throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        A=new int[N];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;i++){
            A[i]= Integer.parseInt(st.nextToken());
        }
        operations=new int[4];
        st=new StringTokenizer(br.readLine());
        for(int i =0;i<4;i++){
            operations[i]= Integer.parseInt(st.nextToken());
        }

        dfs(A[0],1);
    }

    static void dfs(int a,int count){
        if(count==N){
            findTargetNumber(a);
            return;
        }

        for(int i = 0 ;i<4;i++) {
            if(operations[i]==0) continue;
            operations[i]--;
            int t;
            switch (i){
                case 0:
                    t=a+A[count];
                    break;
                case 1:
                    t=a-A[count];
                    break;
                case 2:
                    t=a*A[count];
                    break;
                case 3:
                    t=a/A[count];
                    break;
                default:
                    t=-1;
                    break;
            }
            dfs(t,count+1);
            operations[i]++;
        }
    }

    static void findTargetNumber(int num){
        if(maxValue<num){
            maxValue=num;
        }
        if(minValue>num){
            minValue=num;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
