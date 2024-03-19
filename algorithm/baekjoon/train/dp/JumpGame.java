import java.util.*;
import java.io.*;

public class JumpGame{

    static int testCase;
    static int n;
    static int[][] board;
    static int[][] cache;

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase= Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            n= Integer.parseInt(br.readLine());

            board = new int[n][n];
            cache = new int[n][n];

            for(int j =0 ; j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++){
                    board[j][k]= Integer.parseInt(st.nextToken());
                    cache[j][k]=-1;
                }
            }

            int result = sol(0,0);
            if(result == 1) System.out.println("Yes");
            else System.out.println("No");


            // 보드판을 보기 위함
            for(int[] arr : cache){
                for(int b=0;b<n;b++){
                    System.out.print(arr[b]+" ");
                }
                System.out.println();
            }
        }

    }

    public static int sol(int x, int y){
        if(x<0 || x>=n || y<0 || y>=n) return 0;
        else if (x==n-1 && y==n-1) return 1;

        if(cache[y][x]!=-1) return cache[y][x];
        return cache[y][x] = sol(x+board[y][x],y) | sol(x,y+board[y][x]);
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}