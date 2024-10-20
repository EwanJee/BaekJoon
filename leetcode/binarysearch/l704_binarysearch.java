package leetcode.binarysearch;

public class l704_binarysearch {
    public static int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }
    private static int binarySearch(int[] nums, int target) {
        int mid;
        int right = nums.length - 1;
        int left = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {2,5};
        int target = 5;
        System.out.println(search(nums, target));
    }
}
