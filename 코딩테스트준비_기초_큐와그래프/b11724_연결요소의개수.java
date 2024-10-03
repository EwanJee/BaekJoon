package 코딩테스트준비_기초_큐와그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11724_연결요소의개수 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int[][] arr = new int[nodes + 1][nodes + 1];
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = arr[end][start] = 1;
        }
        for (int i = 1; i < nodes + 1; i++) {
            if (!visited[i]) {
                dfs(i, arr, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int current, int[][] arr, boolean[] visited) {
        visited[current] = true;
        for (int i = 1; i < arr.length; i++) {
            if (!visited[i] && arr[current][i] == 1) {
                dfs(i, arr, visited);
            }
        }
    }
}
