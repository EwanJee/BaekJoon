import java.util.*;
public class sw1 {
    public static int[] solution2(int N, int[] A, int[] B) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i , new int[] {A[i], B[i]});
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 1;
            int[] base = new int[] {A[i], B[i]};
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                int[] other = map.get(j);
                if (base[0] == other[0] && base[1] == other[1]) {
                    continue;
                }
                if (base[0] < other[1] && base[1] > other[0]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        // {1, 5, 6, 3, 3}, {3, 7, 8, 5, 5}
//        int N = 5;
//        int[] A = {1, 5, 6, 3, 3};
//        int[] B = {3, 7, 8, 5, 5};
        int N = 3;
        int[] A = {1, 2, 5};
        int[] B = {4, 6, 8};
        int[] result = solution2(N, A, B);
        System.out.println(Arrays.toString(result));
    }
}