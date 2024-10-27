package leetcode.binarysearch;

public class l153_FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int mid;
            int answer = Integer.MAX_VALUE;
            while(left <= right) {
                mid = (left + right) / 2;
                answer = Math.min(answer, nums[mid]);
                if (nums[mid] <= nums[right]) {
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            return answer;
        }
    }
}
