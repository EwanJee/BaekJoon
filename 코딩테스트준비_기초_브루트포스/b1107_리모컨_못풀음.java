package 코딩테스트준비_기초_브루트포스;

import java.util.*;
import java.io.*;
public class b1107_리모컨_못풀음 {
    /**
     * N = 50만
     * 2초
     * O(n)
     * O(nlogn)
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int nones = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(i + "");
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<nones; i++){
            String button = st.nextToken();
            list.remove(list.indexOf(button));
        }
        if(target == 100){
            System.out.println(0);
            return;
        }
        int first = Math.abs(target - 100); // 1. +/- 로만 이동


    }
}
