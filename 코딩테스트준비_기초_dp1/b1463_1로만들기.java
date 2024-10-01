package 코딩테스트준비_기초_dp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1463_1로만들기 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = dp[1] = 0;
        dfs(N);
        System.out.println(dp[N]);
    }

    private static void dfs(int N) {
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
    }
}
