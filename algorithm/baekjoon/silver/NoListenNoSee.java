import java.util.*;
import java.io.*;



/**
 * 우선 일반적인 배열을 사용하게 될 경우 2중 for문을 사용하게 되고
 * 이때 시간 복잡도가 N^M이 나오기 때문에 문제를 통과하지 못한다.
 */

public class NoListenNoSee{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();

    static int N;
    static int M;
    static String[] strArray;   //보도 못한 명단

    /**
     * HashSet
     * ->저장순서, 중복 x
     *
     * ->해시 함수를 사용해 빠른 검색 가능
     *   해시 함수를 사용 할 경우 해시 테이블 특성에 따라 삽입,삭제 시간 복잡도가 O(1)
     *
     * ->set은 순서가 없고, 중복 허용을 안한다는 것이 특징이다.
     *
     * ->값을 읽을 때는 iterator를 통해 처음부터 끝까지 읽어야 한다
     */
    static Set<String> hashSet =new HashSet<>();    //듣도 못한 명단

    static void input() throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        //듣도 못한 명단 초기화
        for(int i=1;i<=N;i++){
            hashSet.add(br.readLine());
        }


        //M을 바탕으로 배열의 크기를 정한 후
        //보도 못한 명단 초기화
        strArray=new String[M+1];
        for(int i=1;i<=M;i++){
            strArray[i]=br.readLine();
        }
    }

    static void realFunc() throws IOException {

        //정답 담는 ArrayList
        ArrayList<String> ans=new ArrayList<>();

        //보도 못한 사람이 앞에 정의된 듣도 못한 사람에 포함 되는지
        for(int i=1;i<=M;i++){
            if(hashSet.contains(strArray[i])){
                ans.add(strArray[i]);
            }
        }

        //오름차순 정렬
        Collections.sort(ans);

        sb.append(ans.size()).append("\n");
        for(int i=0;i<ans.size();i++){
            sb.append(ans.get(i)).append("\n");
        }

    }

    public static void main(String[] args) throws IOException{
        input();
        realFunc();
        System.out.println(sb);
    }
}

