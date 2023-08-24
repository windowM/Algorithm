public class PutOperation{

    static int N;
    static int[] number;
    static int[] op;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        number=new int[N];
        op=new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            number[i]= Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i]= Integer.parseInt(st.nextToken());
        }
    }

    public void backTracking(int num, int index){
        if(index==N){
            MAX=Math.max(MAX,num);
            MIN=Math.min(MIN,num);
            return;
        }

        for(int i=0;i<4;i++){
            if(op[i]>0){
                op[i]--;
                switch (i){
                    case 0: backTracking(num+number[index],index+1); break;
                    case 1: backTracking(num-number[index],index+1); break;
                    case 2: backTracking(num*number[index],index+1); break;
                    case 3: backTracking(num/number[index],index+1); break;
                }
                op[i]++;
            }
        }

    }


    public static void main(String[] arsgs){
        input();
        backTracking(number[0],1);
        System.out.println(MAX);
        System.out.println(Min);
    }

}