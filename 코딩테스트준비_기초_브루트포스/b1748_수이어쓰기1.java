package 코딩테스트준비_기초_브루트포스;

import java.util.*;
import java.io.*;
public class b1748_수이어쓰기1 {
    /**
     * 0.15초
     * N = 1억
     * O(1)
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        System.out.println(solve2(N));
        int length = 0;
        int digits = 1;
        int range = 9;
        while (N > 0) {
            if (N >= range) {
                length += digits * range;
                N -= range;
            } else {
                length += digits * N;
                N = 0;
            }
            digits++;
            range *= 10;
        }

        System.out.println(length);
    }
    private static int solve2(int N){
        int count = 0;
        int plus = 1;
        int num = 10;
        for(int i=1; i<=N; i++){
            if(i == num){
                plus ++;
                num *= 10;
            }
            count += plus;
        }
        return count;
    }
}
