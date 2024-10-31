package leetcode.binarysearch;

public class l154_FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2;
            min = Math.min(min, nums[mid]);
            // 중복된 요소 처리
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
}
