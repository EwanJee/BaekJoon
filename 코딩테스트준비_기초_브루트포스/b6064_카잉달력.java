package 코딩테스트준비_기초_브루트포스;

import java.util.*;
import java.io.*;
public class b6064_카잉달력 {
    /**
     * 1초
     * M,N 40,000
     * NlogN
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(solve(M,N,x,y));
        }
    }
    private static int solve(int M, int N, int x, int y){
        int max = lcm(M,N);
        while (x<=max){
            if((x-y)%N == 0){
                return x;
            }
            x+=M;
        }
        return -1;
    }
    private static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    private static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}
