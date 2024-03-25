package 코딩테스트준비_기초_브루트포스_재귀;

import java.util.*;
import java.io.*;
public class b9095_123더하기 {
    /**
     * https://lotuslee.tistory.com/43
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for(int i=0; i<N; i++){
            int target = Integer.parseInt(br.readLine());
            System.out.println(dp[target]);
        }
    }
}
