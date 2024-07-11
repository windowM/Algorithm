import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {

    static int N;
    static int[][] map;
    static int countOne=0;
    static int countZero=0;
    static int countMinusOne=0;

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

        composition(0,0,N);
        System.out.println(countMinusOne);
        System.out.println(countZero);
        System.out.println(countOne);
    }

    static void composition(int x,int y,int size){
        if(numCheck(x,y,size)){
            if(map[y][x]==1){
                countOne++;
            }else if(map[y][x]==0){
                countZero++;
            }else{
                countMinusOne++;
            }
            return;
        }
        int newSize=size/3;
        composition(x,y,newSize);//1,1
        composition(x+newSize,y,newSize);//1,2
        composition(x+newSize+newSize,y,newSize);//1,3

        composition(x,y+newSize,newSize);//2,1
        composition(x+newSize,y+newSize,newSize);//2,2
        composition(x+newSize+newSize,y+newSize,newSize);//2,3

        composition(x,y+newSize+newSize,newSize);//3,1
        composition(x+newSize,y+newSize+newSize,newSize);//3,2
        composition(x+newSize+newSize,y+newSize+newSize,newSize);//3,3
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
