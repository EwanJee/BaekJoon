package 코딩테스트준비_기초_수학;

import java.util.Scanner;

public class b17427_약수의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (long) n / i * i;
        }

        System.out.println(answer);
    }
}
