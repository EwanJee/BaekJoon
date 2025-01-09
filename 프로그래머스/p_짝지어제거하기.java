package 프로그래머스;

import java.util.*;

public class p_짝지어제거하기 {
    class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) return 1;
            return 0;
        }
    }
}
