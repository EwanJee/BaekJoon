package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3085_사탕게임_dfs {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<N; j++){
                grid[i][j] = s.charAt(j) + "";
            }
        }
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(!grid[i][j].equals(grid[i][j+1])){
                    String temp = grid[i][j];
                    grid[i][j] = grid[i][j+1];
                    grid[i][j+1] = temp;
                    max = Math.max(max,dfs_r(grid,1,0,0, max));
                    temp = grid[i][j];
                    grid[i][j] = grid[i][j+1];
                    grid[i][j+1] = temp;
                }
            }
            break;
        }
//        System.out.println(max);
    }
    private static int dfs_r(String[][] grid, int sum, int r, int c, int max){
        if(c == grid[0].length-1){
            if(r == grid.length-1) {
                System.out.println(-2);
                return Math.max(max, sum);
            }
            dfs_r(grid,1,r+1,0,Math.max(sum,max));
            System.out.println(3);
        }
        else {
            if (grid[r][c].equals(grid[r][c + 1])) {
                dfs_r(grid, sum + 1, r, c + 1, max);
                System.out.println(4);
            }
            else {
                dfs_r(grid, 1, r, c + 1, Math.max(sum, max));
                System.out.println(5);
            }
        }
        System.out.println(-1);
        return -1;
    }
}
