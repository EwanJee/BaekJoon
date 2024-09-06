package 코딩테스트준비_기초_브루트포스_N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15650_N과M2_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        boolean[] visited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        pick(N, M, arr, visited, sb, 0);
        System.out.println(sb);
    }

    private static void pick(int N, int M, int[] arr, boolean[] visited, StringBuilder sb, int depth) {
        if (depth == M) {
            for (int e : arr) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (depth >0 && arr[depth-1] > i) continue;
                visited[i] = true;
                arr[depth] = i;
                pick(N, M, arr, visited, sb, depth + 1);
                visited[i] = false;
            }
        }
    }
}
