package 코딩테스트준비_기초_브루트포스_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14501_퇴사_dp {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] time = new int[N];
        int[] price = new int[N];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            price[i] = p;
        }
        for (int i = 0; i < N; i++) {
            if( i + time[i] <= N) dp[i + time[i]] = Math.max(dp[i] + price[i], dp[i + time[i]]);
            dp[i+1] = Math.max(dp[i],dp[i+1]);
        }
        System.out.println(dp[N]);
    }
}
