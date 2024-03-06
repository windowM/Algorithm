import java.io.*;
import java.util.*;

public class P19532 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int a,b,c,d,e,f;

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        d= Integer.parseInt(st.nextToken());
        e= Integer.parseInt(st.nextToken());
        f= Integer.parseInt(st.nextToken());
    }

    public static void calc() throws IOException {
        // ax+by=c
        // dx+ey=f
        for(int x=-999 ; x<=9999;x++){
            for (int y = -999;y<=999;y++){
                if(((a*x)+(b*y)==c) && ((d*x+e*y)==f)){
                    bw.write(x+" "+y);
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        calc();
        bw.flush();
        bw.close();
    }
}
