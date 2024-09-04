package 코딩테스트준비_기초_브루트포스_N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649_N과M1_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        pick(sb, N, M, visited, new int[M], 0);
        System.out.println(sb);
    }

    private static void pick(StringBuilder sb, int N, int M, boolean[] visited, int[] arr, int depth) {
        if (depth == M) {
            for (int e : arr) sb.append(e).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                pick(sb, N, M, visited, arr,depth+1);
                visited[i] = false;
            }
        }
    }
}
