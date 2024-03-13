package 코딩테스트준비_기초_브루트포스;

import java.io.*;
import java.util.*;
public class b1476_날짜계산 {
//    static int year = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());
        // earth ~ 15
        // sun ~ 28
        // moon ~ 19
        //dfs(earth,sun,moon);
        System.out.println(solve(earth,sun,moon));
    }
    private static int solve(int earth, int sun, int moon){
        int year = earth;
        while (year <= 15 * 28 * 19){
            if((year-sun)%28 == 0 && ((year-moon)%19) == 0){
                return year;
            }
            year += 15;
        }
        return year;
    }
//    private static void dfs(int earth, int sun, int moon){
//        if(earth==1 && sun==1 && moon==1){
//            year++;
//            return;
//        }
//        if(earth == 1) {
//            earth = 16;
//        }
//        if(sun == 1){
//            sun = 29;
//        }
//        if (moon == 1){
//            moon = 20;
//        }
//        year++;
//        dfs(earth-1,sun-1,moon-1);
//    }
}
