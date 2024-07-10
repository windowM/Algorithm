import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {

    static int whiteCount=0;
    static int blueCount=0;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        map=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void partition(int x,int y,int size){
        if(checkColor(x,y,size)){
            if(map[y][x]==1) blueCount++;
            else whiteCount++;
            return;
        }

        int newSize=size/2;
        partition(x,y,newSize); //2사분면
        partition(x+newSize,y,newSize); //1사분면
        partition(x,y+newSize,newSize); //3사분면
        partition(x+newSize,y+newSize,newSize); //4사분면
    }

    static boolean checkColor(int x,int y,int size){
        int color=map[y][x];

        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=color) return false;
            }
        }
        return true;
    }
}
