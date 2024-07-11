import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
    static int N;
    static int[][] map;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=0;i<N;i++){
            String oneLine=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=oneLine.charAt(j)-'0';
            }
        }
        partition(0,0,N);
        System.out.println(sb);
    }

    static void partition(int x,int y,int size){
        if(numCheck(x,y,size)){
            sb.append(map[y][x]);
            return;
        }
        int newSize=size/2;
        sb.append("(");
        partition(x,y,newSize); //2사분면
        partition(x+newSize,y,newSize); //1사분면
        partition(x,y+newSize,newSize);//3사분면
        partition(x+newSize,y+newSize,newSize);//4사분면
        sb.append(")");
    }

    static boolean numCheck(int x, int y, int size){
        int num=map[y][x];
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=num) return false;
            }
        }

        return true;
    }
}
