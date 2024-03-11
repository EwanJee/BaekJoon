package 코딩테스트준비_기초_브루트포스;

import java.util.*;
import java.io.*;
public class b14500_테트로미노 {
    /**
     * 2초
     * N,M 500
     * N^3
     */
    static int[][] arr;
    static int r,c;
    static boolean[][] visited;
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        arr = new int[rows][columns];
        r = rows; c = columns;
        visited = new boolean[rows][columns];
        for(int i=0; i<rows; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<columns; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> maxList = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                visited[i][j] = true;
                dfs(maxList,arr[i][j],i,j,1);
                visited[i][j] = false;

                one(maxList,i,j,arr[i][j]);
            }
        }
        System.out.println(Collections.max(maxList));
    }
    private static void one(List<Integer> maxList, int x, int y, int max){
        // -1,0 1,0 0,1
        // 0,1 -1,0 1,0
        // 1,0 1,0 0,1
        // 0,-1 -1,0 1,0
        //ㅜ
        if(x<r-1 && y>0 && y<c-1) max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x][y-1]);
        //ㅗ
        if(x>0 && y>0 && y<c-1) max = Math.max(max, arr[x][y] + arr[x][y-1] + arr[x-1][y] + arr[x][y+1]);
        //ㅏ
        if(x>0 && y<c-1 && x<r-1) max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x-1][y] + arr[x][y+1]);
        //ㅓ
        if(x>0 && x<r-1 && y>0)  max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x-1][y] + arr[x][y-1]);
        maxList.add(max);
    }
    private static void dfs(List<Integer> maxList, int max, int x, int y, int depth){
        if(depth == 4){
            maxList.add(max);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<r && ny<c){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(maxList, max + arr[nx][ny], nx, ny, depth+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
