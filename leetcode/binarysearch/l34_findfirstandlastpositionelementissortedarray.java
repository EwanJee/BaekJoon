package leetcode.binarysearch;

public class l34_findfirstandlastpositionelementissortedarray {
    public int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }

    private int findStart(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int answer = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                right = mid -1;
            }
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return answer;
    }

    private int findEnd(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int answer = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            }
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return answer;
    }
}
