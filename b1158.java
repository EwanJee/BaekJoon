import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1158 {
    public class TrashDayChecker {

        public static int[] isTrashDayWeekend(int k, int day) {
            int[] result = new int[12]; // 각 월의 쓰레기 날 주말 여부
            int[] weekends = getWeekends(day); // 주말

            for (int month = 0; month < 12; month++) {
                k = k % 7;
                if (k == weekends[0] || k == weekends[1]) {
                    result[month] = 1;
                }
                k += getDaysInMonth(month+1);
            }

            return result;

        }
        public static int getDaysInMonth(int month) {
            if (month == 2) return 28;
            if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
            return 31;
        }
        public static int[] getWeekends(int day) {
            if (day == 6) return new int[] {0,1};
            if (day == 5) return new int[] {1,2};
            if (day == 4) return new int[] {2,3};
            if (day == 3) return new int[] {3,4};
            if (day == 2) return new int[] {4,5};
            if (day == 1) return new int[] {5,6};
            return new int[] {6,0};
        }
    }
}
