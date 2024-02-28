import java.util.*;
import java.io.*;
public class b2023_신기한소수 {
    static boolean[] arr;
    static int number;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println("2\n3\n5\n7");
            return;
        }
        StringBuilder sb = new StringBuilder();
        number = (int) Math.pow(10,N-1);
        arr = new boolean[number];
        esteratos();
        for(int i=2; i<number; i++){
            if(!arr[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void esteratos(){
        arr[0] = arr[1] = true;
        for(int i=2; i < Math.sqrt(number); i++){
            for(int j = i*i; j<number; j+=i){
                if(arr[j]){
                    continue;
                }
                arr[j] = true;
            }
        }
    }
}
