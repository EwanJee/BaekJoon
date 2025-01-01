import java.io.*;
import java.util.*;

public class Solution2 {
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            List<Integer> dp = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (int start = 0; start <= N - K; start++) {
                int sum = 0;
                for (int temp = 0; temp < K; temp++) {
                    sum += arr[start + temp];
                }
                dp.add(sum);
            }
            System.out.println("#" + (i + 1) + " " + solve(dp, max));
        }
    }
    private static int solve(List<Integer> dp, int max) {
        for (int i = 0; i < dp.size(); i++) {
            for (int j = i + K; j < dp.size(); j++) {
                max = Math.max(max, dp.get(i) + dp.get(j));
            }
        }
        return max;
    }
}
/**
 * [제약사항]
 * <p>
 * 1.	N은 4 이상 3,000 이하이다. (4 ≤ N ≤ 3,000)
 * <p>
 * 2.	K는 1 이상 [N/2]이하의 값이다. [N/2]는 N/2보다 크지 않은 최대 정수를 의미한다.
 * <p>
 * 3.	배열의 원소는 -10,000 이상, 10,000 이하의 정수이다.
 * <p>
 * <p>
 * <p>
3
6 2
2 4 3 -4 6 1
4 1
3 4 5 1
4 2
-2 -3 -4 -1
 * <p>
 * [출력]
 * #1 14
 * #2 9
 * #3 -10
 */