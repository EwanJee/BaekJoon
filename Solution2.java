import java.io.*;
import java.util.*;

public class Solution2 {
    static int K;

    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 20};
//        System.out.println(lis(arr)); // 출력: 4
        lis(arr);
    }

    private static int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
        return left;
    }

    public static int lis(int[] arr) {
        List<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int pos = binarySearch(lis, num);
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        System.out.println(lis);
        return lis.size();
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