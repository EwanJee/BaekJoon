package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15486_퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int maxProfit = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            maxProfit = Math.max(maxProfit, dp[i]);

            if (i+weight > N) continue;

            dp[i+weight] = Math.max(dp[i+weight], maxProfit + value);
        }

        System.out.println(Math.max(maxProfit, dp[N]));
    }
}
