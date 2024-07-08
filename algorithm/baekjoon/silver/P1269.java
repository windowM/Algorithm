import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int aLength= Integer.parseInt(st.nextToken());
        int bLength= Integer.parseInt(st.nextToken());

        Map<Integer,Integer > map=new HashMap<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<aLength;i++){
            int a= Integer.parseInt(st.nextToken());
            map.put(a,map.getOrDefault(a,0)+1);
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<bLength;i++){
            int a= Integer.parseInt(st.nextToken());
            map.put(a,map.getOrDefault(a,0)+1);
        }

        int count=0;
        for(Map.Entry entry :map.entrySet()){
            if(map.get(entry.getKey())==1){
                count++;
            }
        }
        System.out.println(count);


    }
}
