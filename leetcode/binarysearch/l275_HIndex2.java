package leetcode.binarysearch;

public class l275_HIndex2 {
    class Solution {
        public int hIndex(int[] citations) {
            int left = 0;
            int right = citations.length - 1;
            int mid;
            int remained;
            int output = -1;
            while (left <= right) {
                mid = (left + right) / 2;
                remained = citations.length - mid;
                if (citations[mid] == remained) {
                    output = remained;
                    return output;
                }
                else if (citations[mid] < remained) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return citations.length - left;
        }
    }
}
