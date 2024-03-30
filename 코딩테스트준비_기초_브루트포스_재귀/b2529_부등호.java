package 코딩테스트준비_기초_브루트포스_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2529_부등호 {
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static String smax = "";
    static String smin = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        boolean[] visited = new boolean[10];
        solve(N, arr, visited, "", 0);
        System.out.println(smax);
        System.out.println(smin);
    }

    private static void solve(int N, String[] arr, boolean[] visited, String answer, int depth) {
        if (depth == N + 1) {
            long input = Long.parseLong(answer);
            max = Math.max(max, input);
            min = Math.min(min, input);
            if (min == input) {
                smin = answer;
            }
            if (max == input) {
                smax = answer;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (depth == 0) {
                    visited[i] = true;
                    solve(N, arr, visited, answer + i, depth + 1);
                    visited[i] = false;
                } else {
                    if (arr[depth - 1].equals("<")) {
                        int prev = Integer.parseInt(answer.charAt(depth - 1) + "");
                        int curr = i;
                        if (prev < curr) {
                            visited[i] = true;
                            solve(N, arr, visited, answer + i, depth + 1);
                            visited[i] = false;
                        }
                    } else if (arr[depth - 1].equals(">")) {
                        int prev = Integer.parseInt(answer.charAt(depth - 1) + "");
                        int curr = i;
                        if (prev > curr) {
                            visited[i] = true;
                            solve(N, arr, visited, answer + i, depth + 1);
                            visited[i] = false;
                        }
                    }
                }
            }
        }
    }
}
