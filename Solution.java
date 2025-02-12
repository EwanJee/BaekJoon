import java.io.*;
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        if (A.length == 0) return 0;

        int maxValidLength = 1;
        int currentLength = 1;

        for (int i = 1; i < A.length; i++) {
            if (Math.abs(A[i] - A[i - 1]) == 1) {
                currentLength++;
            } else {
                maxValidLength = Math.max(maxValidLength, currentLength);
                currentLength = 1;  // 새로운 시작점
            }
        }
        maxValidLength = Math.max(maxValidLength, currentLength);

        return A.length - maxValidLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A1 = {3, 2, 4, 1, 3, 2};
        int[] A2 = {1, 1, 1, 2, 3};

        System.out.println(sol.solution(A1));  // 1
        System.out.println(sol.solution(A2));  // 2
    }
}
