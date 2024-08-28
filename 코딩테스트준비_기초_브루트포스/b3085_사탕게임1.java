package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b3085_사탕게임1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < N; j++) {
                String element = input.charAt(j) + "";
                grid[i][j] = element;
            }
        }
        System.out.println(pickTheBest(grid));
    }

    private static int pickTheBest(String[][] grid) {
        int max = 0;
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(grid, i, j, i, j + 1);
                max = Math.max(max, getCandy(grid));
                swap(grid, i, j, i, j + 1);
            }
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(grid, i, j, i + 1, j);
                max = Math.max(max, getCandy(grid));
                swap(grid, i, j, i + 1, j);
            }
        }
        return max;
    }

    private static void swap(String[][] grid, int x1, int y1, int x2, int y2) {
        String temp = grid[x1][y1];
        grid[x1][y1] = grid[x2][y2];
        grid[x2][y2] = temp;
    }

    private static int getCandy(String[][] grid) {
        int N = grid.length;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (grid[i][j].equals(grid[i][j + 1])) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (grid[i][j].equals(grid[i + 1][j])) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
