import java.util.*;
import java.io.*;
public class b2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int gcd = gcd(max, min);
        int gcs = a * b / gcd;
        System.out.println(gcd);
        System.out.println(gcs);
    }

    private static int gcd(int max, int min) {
        if(min==0){
            return max;
        }
        return gcd(min, max%min);
    }
}
