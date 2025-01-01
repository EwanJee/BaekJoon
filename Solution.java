import java.io.*;
import java.util.*;

public class Solution {
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int element = Integer.parseInt(st.nextToken());
                list.add(element);
            }
            System.out.println("#" + (test_case) + " " + solve(list, set, 0));
            list = new ArrayList<>();
            set = new HashSet<>();
        }
    }

    private static int solve(List<Integer> list, Set<String> set, int count) {
        if (!addCurrent(list, set)) {
            return -1;
        }
        if (check(list)) return count;
        int insert = list.get(K - 1);
        list.remove(0);
        list.add(insert);
        return solve(list, set, count + 1);
    }

    private static boolean check(List<Integer> list) {
        int first = list.get(0);
        for (int e : list) {
            if (first != e) return false;
        }
        return true;
    }

    private static boolean addCurrent(List<Integer> list, Set<String> set) {
        StringBuilder s = new StringBuilder();
        for (int e : list) {
            s.append(e);
        }
        if (set.contains(s.toString())) {
            return false;
        }
        set.add(s.toString());
        return true;
    }
}
