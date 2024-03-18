import java.io.*;
import java.util.StringTokenizer;

public class Picnic {

    static int n;
    static int m;
    static boolean[][] areFriends;
    static boolean[] visited;
    static int count;

    public static void setUp(){
        count = 0;
        areFriends = new boolean[10][10];
        visited = new boolean[10];
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            setUp();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int firstPerson = Integer.parseInt(st.nextToken());
                int nextPerson = Integer.parseInt(st.nextToken());
                areFriends[firstPerson][nextPerson] = true;
                areFriends[nextPerson][firstPerson] = true;
            }
            dfs();
            System.out.println(count);
        }
    }

    public static void dfs() {
        int pickPerson=-1;
        for( int i=0;i<n;i++){
            if(!visited[i]) pickPerson=i;
        }
        if(pickPerson==-1) {
            count++;
            return;
        }

        for( int i=0;i<n;i++){
            if(i==pickPerson) continue;
            if(areFriends[pickPerson][i] && !visited[i]){
                visited[pickPerson]=visited[i]=true;
                dfs();
                visited[pickPerson]=visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
}
