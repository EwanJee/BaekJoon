package 코딩테스트준비_기초_큐와그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260_dfs와bfs {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = arr[end][start] = 1;
        }
        dfs(V, arr, visited);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V, arr, visited);
        System.out.println(sb);
    }

    private static void bfs(int start, int[][] arr, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");
            for (int i = 1; i < arr.length; i++) {
                if (arr[start][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int start, int[][] arr, boolean[] visited) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i, arr, visited);
            }
        }
    }
}
