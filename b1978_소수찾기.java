import java.util.*;
import java.io.*;
public class b1978_소수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i=0; i<N; i++){
            int each = Integer.parseInt(st.nextToken());
            if(esteratos(each)){
                total++;
            }
        }
        System.out.println(total);
    }
    private static boolean esteratos(int number){
        if(number == 1) return false;
        for(int i=2; i<= (int) Math.sqrt(number);i++){
            if(number%i==0){
                return false;//소수가 아님
            }
        }
        return true;
    }
}
