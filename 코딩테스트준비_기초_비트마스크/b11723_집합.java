package 코딩테스트준비_기초_비트마스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b11723_집합 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("empty")) empty(set);
            else if (command.equals("all")) all(set);
            else {
                int target = Integer.parseInt(st.nextToken());
                switch (command) {
                    case "add" -> add(set, target);
                    case "check" -> sb.append(check(set, target)).append("\n");
                    case "remove" -> remove(set, target);
                    case "toggle" -> toggle(set, target);
                }
            }
        }
        System.out.println(sb);
    }

    private static void add(Set<Integer> set, int target) {
        set.add(target);
    }

    private static int check(Set<Integer> set, int target) {
        if (set.contains(target)) return 1;
        return 0;
    }

    private static void remove(Set<Integer> set, int target) {
        set.remove(target);
    }

    private static void toggle(Set<Integer> set, int target) {
        if (set.contains(target)) set.remove(target);
        else {
            set.add(target);
        }
    }

    private static void empty(Set<Integer> set) {
        set.clear();
    }

    private static void all(Set<Integer> set) {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }
}
