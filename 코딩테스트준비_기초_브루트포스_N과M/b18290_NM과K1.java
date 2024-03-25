package 코딩테스트준비_기초_브루트포스_N과M;

import java.util.*;
import java.io.*;

public class b18290_NM과K1 {
    static int max = Integer.MIN_VALUE;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        dfs(0,0,N,M,K,0,0,grid,visited);
        System.out.println(max);
    }

    private static void dfs(int depth, int sum, int N, int M, int K, int x, int y, int[][] grid, boolean[][] visited) {
        if (depth == K) {
            max = Math.max(max, sum);
            System.out.println(sum);
            return;
        }
        for(int a=x; a<N; a++) {
            for(int b=y; b<M; b++) {
                if(!visited[a][b]) {
                    boolean check = true;
                    for (int i = 0; i < 4; i++) {
                        int nx = a + dx[i];
                        int ny = b + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (visited[nx][ny]) {
                                check = false;
                            }
                        }
                    }
                    if(check){
                        visited[a][b] = true;
                        dfs(depth + 1, sum + grid[a][b], N, M, K, x, y, grid, visited);
                        visited[a][b] = false;
                    }
                }
            }
        }
    }
}
