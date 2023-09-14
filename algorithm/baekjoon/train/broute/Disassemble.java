
public class Disassemble{
    static int N;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
    }

    public static int search(){
        for(int i=0;i<N;i++){
            int number=i;
            int sum=i;
            while (number!=0){
                sum+=number%10;
                number/=10;
            }
            if(sum==N){
                return  i;
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(search());
    }
}