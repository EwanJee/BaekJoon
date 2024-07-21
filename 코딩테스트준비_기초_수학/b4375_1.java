package 코딩테스트준비_기초_수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b4375_1 {
    /**
     * 시간 제한 1초
     * n <= 10^4
     * O(n^2)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=br.readLine())!=null){
            int n=Integer.parseInt(input);
            int oneNumber=1;
            int cnt=1;
            while(true){
                if(oneNumber%n==0){
                    System.out.println(cnt);
                    break;
                }
                oneNumber=(oneNumber*10)+1;
                oneNumber= oneNumber % n; //모듈러 연산 적용
                cnt++;
            }
        }
    }
}
