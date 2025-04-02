package SW_역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 보물상자비밀번호 {
    static List<String> keys = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    static int SIZE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            SIZE = N / 4;
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i) + "");
            }
            sb.append("#").append(t).append(" ");
            sb.append(solve(N, K));
            sb.append("\n");
            keys = new ArrayList<>();
            list = new ArrayList<>();
        }
        System.out.println(sb);

    }

    private static String solve(int N, int K) {
        for (int r = 0; r <= SIZE; r++) {
            String removed = list.remove(list.size()-1);
            list.add(0, removed);
            String key = "";
            for (int i = 0; i < list.size(); i++) {
                key += list.get(i);
                if (key.length() == SIZE) {
                    if (!keys.contains(key)) keys.add(key);
                    key = "";
                }
            }
        }
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                for (int i = 0; i < a.length(); i++) {
                    String a1 = a.charAt(i) + "";
                    String b1 = b.charAt(i) + "";
                    int aSize = Integer.parseInt(a1, 16);
                    int bSize = Integer.parseInt(b1, 16);
                    if (aSize > bSize) return -1;
                    if (aSize < bSize) return 1;
                }
                return 0;
            }
        });
        String k = keys.get(K - 1);
        return String.valueOf(Integer.parseInt(k, 16));
    }
}
