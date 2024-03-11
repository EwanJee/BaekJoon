package 코딩테스트준비_기초_브루트포스;

import java.util.*;
import java.io.*;

public class b3085_사탕게임 {
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
        // COLUMN
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(!grid[i][j].equals(grid[i][j+1])){
                    String temp = grid[i][j];
                    grid[i][j] = grid[i][j+1];
                    grid[i][j+1] = temp;
                    max = changeAndUpdateMax(grid, max, i, j, i, j+1, N);
                    temp = grid[i][j];
                    grid[i][j] = grid[i][j+1];
                    grid[i][j+1] = temp;
                }
            }
        }
        // ROW
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(!grid[j][i].equals(grid[j+1][i])){
                    String temp = grid[j][i];
                    grid[j][i] = grid[j+1][i];
                    grid[j+1][i] = temp;
                    max = changeAndUpdateMax(grid, max, j, i, j+1, i, N);
                    temp = grid[j][i];
                    grid[j][i] = grid[j+1][i];
                    grid[j+1][i] = temp;
                }
            }
        }
        System.out.println(max);
    }

    private static int changeAndUpdateMax(String[][] grid, int max, int r1, int c1, int r2, int c2, int N) {
//        String temp = grid[r1][c1];
//        grid[r1][c1] = grid[r2][c2];
//        grid[r2][c2] = temp;
        String temp;

        //COLUMN CHECK
        int comp = 0;
        for(int i=0; i<N; i++){
            temp = grid[i][0];
            comp = 0;
            for(int j=0; j<N; j++){
                if(temp.equals(grid[i][j])){
                    comp++;
                }
                else{
                    max = Math.max(max,comp);
                    temp = grid[i][j];
                    comp = 1;
                }
            }
            max = Math.max(max,comp);
        }
        max = Math.max(max,comp);

        //ROW CHECK
        comp = 0;
        for(int i=0; i<N; i++){
            temp = grid[0][i];
            comp = 0;
            for(int j=0; j<N; j++){
                if(temp.equals(grid[j][i])){
                    comp++;
                }
                else{
                    max = Math.max(max, comp);
                    temp = grid[j][i];
                    comp = 1;
                }
            }
            max = Math.max(max,comp);
        }
        max = Math.max(max,comp);

//        temp = grid[r1][c1];
//        grid[r1][c1] = grid[r2][c2];
//        grid[r2][c2] = temp;

        return max;
    }
}
