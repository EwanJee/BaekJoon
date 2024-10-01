package 코딩테스트준비_기초_순열;

import java.io.*;
import java.util.*;

public class b10972_다음순열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (next_permutation(arr)) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    private static boolean next_permutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i -= 1;
        }
        if (i <= 0) return false;
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j -= 1;
        }
        int temp = -arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = temp;

        j = arr.length - 1;

        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}