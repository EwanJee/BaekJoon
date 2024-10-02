package 코딩테스트준비_기초_dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11727_2xn타일링_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007;
        }
        System.out.println(dp[n]);
    }
}
