package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l33_SearchInRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, target);
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == target) return mid;
                //left sorted
                if(nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
