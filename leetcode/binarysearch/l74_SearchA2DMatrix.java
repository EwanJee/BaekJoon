package leetcode.binarysearch;

public class l74_SearchA2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] row : matrix) {
                if (binarySearch(row, target) != -1) return true;
            }
            return false;
        }

        public int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
