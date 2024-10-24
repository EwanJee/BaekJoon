package leetcode.binarysearch;

import java.util.Arrays;

public class l436_findRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int N = intervals.length;
        int[] answer = new int[N];
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            answer[arr[i][2]] = search(arr, arr[i][1]);
        }
        return answer;
    }

    private int search(int[][] arr, int end) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int answer = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid][0] >= end) {
                answer = arr[mid][2];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
