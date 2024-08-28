package 코딩테스트준비_기초_수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b17425_약수의합 {
    /**
     * 1초
     * N = 10^6
     * <p>
     * O(N) or O(NlogN)
     */
    static long[] arr = new long[1_000_001];
    static long[] dp = new long[1_000_001];

    public static void main(String[] args) throws Exception {
        Arrays.fill(arr, 1);
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; i * j < arr.length; j++) {
                arr[i * j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(dp[number]);
        }
    }
}
