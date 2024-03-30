package 코딩테스트준비_기초_브루트포스_재귀;

import java.util.*;
import java.io.*;
public class b14889_스타트와링크 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int p = Integer.parseInt(st.nextToken());
                    map[i][j] = p;
                }
            }
            boolean[] visited = new boolean[N];
            solve(N,map,visited,0,0);
            System.out.println(min);
    }
    private static void solve(int N, int[][] map, boolean[] visited, int current, int depth){
        if(depth == N/2){
            findMin(N,map,visited);
            return;
        }
        for(int i=current; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                solve(N,map,visited,i+1,depth+1);
                visited[i] = false;
            }
        }
    }
    private static void findMin(int N, int[][] map, boolean[] visited){
        int start = 0;
        int link = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]){
                    start += map[i][j];
                    start += map[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int diff = Math.abs(start-link);
        min = Math.min(min,diff);
    }
}
