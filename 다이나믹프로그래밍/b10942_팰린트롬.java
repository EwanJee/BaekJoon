package 다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class b10942_팰린트롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n+1];

        boolean[][] dp = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        setDp(n, nums, dp);


        int m = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(reader.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (dp[left][right]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);


    }

    private static void setDp(int n, int[] nums, boolean[][] dp) {
        for (int i=1; i<=n; i++) {
            dp[i][i] = true;
            if (nums[i] == nums[i-1]) {
                dp[i-1][i] = true;
            }
        }

        for (int i=2; i<n; i++) {
            for (int j=1; j<=n-i; j++) {
                if (nums[j] == nums[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                }
            }
        }
    }
}
