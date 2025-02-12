import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 현대오토에버_2 {
    static int N;
    static int K;
    static int P;
    static int[] B;
    static int[][] grid;
    static boolean[] visited;
    static int max = Integer.MAX_VALUE;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[K];
        B = new int[K];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
    static int knapsackDP() {
        dp = new int[P + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // 점수 0을 만드는 데 비용 0

        for (int k = 0; k < K; k++) {
            List<Integer> possibleDamages = new ArrayList<>();

            // 모든 위치(i, j)에서 k번 무기를 사용할 때 얻을 수 있는 점수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int damage = shoot(i, j, k + 1);
                    if (damage > 0) {
                        possibleDamages.add(damage);
                    }
                }
            }

            // DP 업데이트 (0-1 Knapsack 방식, 뒤에서부터 갱신)
            for (int i = P; i >= 0; i--) {
                for (int damage : possibleDamages) {
                    if (i + damage <= P && dp[i] != Integer.MAX_VALUE) {
                        dp[i + damage] = Math.min(dp[i + damage], dp[i] + B[k]);
                    }
                }
            }
        }

        return dp[P];
    }
    public static void dfs(int score, int count){
        if (score == P) {
            max = Math.min(max, count);
            return;
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<K; k++) {
                    if (!visited[k]) {
                        visited[k] = true;
                        int temp = shoot(i, j, k+1);
                        if (score+temp <= P) dfs(score+temp, count+B[k]);
                        visited[k] = false;
                    }
                }
            }
        }
    }
    public static int shoot(int x, int y, int b) {
        if (b==1) return grid[x][y];
        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (distance(x, y, i, j) < b) {
                    count += grid[i][j];
                }
            }
        }
        return count;
    }
    public static int distance(int x, int y, int i, int j) {
        return Math.abs(x-i) + Math.abs(y-j);
    }
}
