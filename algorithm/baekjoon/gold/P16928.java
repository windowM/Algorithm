import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    //1~6 주사위
    //10x10 보드판 1~100숫자
    //사다리= 이동 x->y로 주어짐
    //뱀=이동 u->v로 주어짐
    // 100번 앞에서 주사위 합이 100이상이면 못움직임
    static int N,M; //사다리수,뱀수
    static int[] map=new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        for(int i=1;i<101;i++){
            map[i]=i;
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            map[x]=y;
        }
        //뱀 정보 = 그냥 피해야 하는 번호
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            map[u]=v;
        }

        bfs();
    }

    static void bfs(){
        int[] check=new int[101];
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()) {
            Integer curIdx = q.poll();
            for (int i = 1; i < 7; i++) {
                int nextIdx=curIdx+i;
                if(nextIdx>100) continue;
                if(check[map[nextIdx]]==0) {
                    check[map[nextIdx]]=check[curIdx]+1;
                    q.offer(map[nextIdx]);

                }
                if(nextIdx==100){
                    System.out.println(check[nextIdx]);
                    return;
                }
            }
        }
    }
}
