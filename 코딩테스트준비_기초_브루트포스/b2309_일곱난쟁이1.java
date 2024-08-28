package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2309_일곱난쟁이1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sumOf9 = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            arr[i] = height;
            sumOf9 += height;
        }
        Arrays.sort(arr);
        int target = sumOf9 - 100;
        int first = 101;
        int second = 101;
        for (int i = 0; i < 9; i++) {
            int sum = 0;
            for (int j = i + 1; j < 9; j++) {
                sum = arr[i] + arr[j];
                if (target == sum) {
                    first = i;
                    second = j;
                    break;
                }
            }
            if (target == sum) {
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == first || i == second) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
