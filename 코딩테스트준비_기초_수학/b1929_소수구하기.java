package 코딩테스트준비_기초_수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1929_소수구하기 {
    static boolean[] arr = new boolean[1_000_001];

    public static void main(String[] args) throws Exception {

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i]) {
                for (int j = i * i; j < arr.length; j += i)
                    arr[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        for (int i = n1; i <= n2; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}
