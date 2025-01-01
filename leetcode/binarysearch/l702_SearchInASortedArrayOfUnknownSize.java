//package leetcode.binarysearch;
//
//public class l702_SearchInASortedArrayOfUnknownSize {
//    public int search(ArrayReader reader, int target) {
//        int left = 0, right = 10000 - 1;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (reader.get(mid) == target) return mid;
//            if (reader.get(mid) < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }
//    public int getIndex(ArrayReader reader) {
//        int left = 0, right = reader.length() - 1;
//        while (left < right) {
//            int t1 = left, t2 = left + (right - left) / 3, t3 = left + (right - left) / 3 * 2 + 1;
//            int cmp = reader.compareSub(t1, t2, t2 + 1, t3);
//            if (cmp == 0) {
//                left = t3 + 1;
//            } else if (cmp == 1) {
//                right = t2;
//            } else {
//                left = t2 + 1;
//                right = t3;
//            }
//        }
//        return left;
//    }
//}
