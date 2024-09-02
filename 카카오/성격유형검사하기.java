package 카카오;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    static Map<Character, Integer> map = new HashMap<>();

    public String solution(String[] array, int[] choices) {
        for (int i = 0; i < array.length; i++) {
            String element = array[i];
            char e1 = element.charAt(0);
            char e2 = element.charAt(1);
            int score = choices[i];
            if (score == 4) continue;
            if (score > 4) {
                map.put(e2, map.getOrDefault(e2, 0) + (score - 4));
            } else {
                map.put(e1, map.getOrDefault(e1, 0) + (4 - score));
            }
        }
        return new StringBuilder()
                .append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
                .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
                .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
                .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
                .toString();
    }
}
