package 코딩테스트준비_기초_큐와그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b2667_단지번호붙이기 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                int e = Integer.parseInt(String.valueOf(s.charAt(j)));
                grid[i][j] = e;
            }
        }
        boolean[][] visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    int houses = bfs(grid, visited, i, j);
                    list.add(houses);
                }
            }
        }

        // 오름차순 정렬 추가
        Collections.sort(list);

        // 출력
        System.out.println(count);
        for (int e : list) {
            System.out.println(e);
        }
    }

    private static int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        int houses = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        houses++;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for (int v = 0; v < 4; v++) {
                int nx = cx + dx[v];
                int ny = cy + dy[v];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid.length) continue;
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    houses++;
                }
            }
        }
        return houses;
    }
}
