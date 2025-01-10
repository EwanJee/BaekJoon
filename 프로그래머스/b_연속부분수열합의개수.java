package 프로그래머스;

import java.util.*;

public class b_연속부분수열합의개수 {

    class Solution {
        public int solution(int[] elements) {
            Set<Integer> uniqueSums = new HashSet<>();
            int n = elements.length;

            // 원형 배열의 합 계산
            for (int length = 1; length <= n; length++) {  // 부분 수열의 길이
                int sum = 0;

                // 첫 번째 부분 수열의 합 계산
                for (int i = 0; i < length; i++) {
                    sum += elements[i];
                }
                uniqueSums.add(sum);

                // 나머지 부분 수열의 합 계산 (슬라이딩 윈도우)
                for (int start = 1; start < n; start++) {
                    sum -= elements[(start - 1) % n];
                    sum += elements[(start + length - 1) % n];
                    uniqueSums.add(sum);
                }
            }

            return uniqueSums.size();
        }
    }
}
