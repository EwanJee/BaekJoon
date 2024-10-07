package 카카오;

import java.util.*;

public class 개인정보수집유효기간 {
    static String TODAY;

    public int[] solution(String today, String[] terms, String[] privacies) {
        TODAY = today;
        int N = privacies.length;
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String term = terms[i];
            String type = term.substring(0, 1);
            int length = Integer.parseInt(term.substring(2));
            map.put(type, length);
        }
        for (int i = 0; i < N; i++) {
            String privacy = privacies[i];
            String date = privacy.substring(0, 10);
            String type = String.valueOf(privacy.charAt(privacy.length() - 1));
            boolean isValid = solve(map, date, type);
            if (isValid) list.add(i + 1);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private boolean solve(Map<String, Integer> map, String a, String type) {
        int length = map.get(type);
        int[] date = addMonths(a, length);
        return compare(date);
    }

    private int[] addMonths(String date, int length) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        month += length;
        if (month > 12) {
            int temp = (month - 1) / 12;
            year += temp;
            month = month - temp * 12;
        }
        return new int[]{year, month, day};
    }

    private boolean compare(int[] date) {
        String[] parts = TODAY.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (year < date[0]) return false;
        if (year == date[0] && month < date[1]) return false;
        if (year == date[0] && month == date[1] && day <= date[2]) return false;
        return true;
    }
}
