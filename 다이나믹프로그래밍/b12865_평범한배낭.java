package 다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class b12865_평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        int[][] items = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i][0] = weight;
            items[i][1] = value;
        }
        for (int i=0; i<N; i++) {
            int[] item = items[i];
            int weight = item[0];
            int value = item[1];
            for (int j=K; j>=weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }
        System.out.println(dp[K]);
    }
}
