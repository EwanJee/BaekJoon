package 코딩테스트준비_기초_브루트포스_N과M;

import java.io.*;
import java.util.*;
public class b15649_N과M1 {
    /**
     * 1초
     * M=N=8
     * 시간복잡도 신경 안써도 된다
     */
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited = new boolean[N+1];
        int[] arr = new int[M];
        for(int i=1; i<=N; i++){
            visited[i] = true;
            arr[0] = i;
            dfs(arr, N,1);
            visited[i] = false;
        }
        System.out.println(sb);
    }
    private static void dfs(int[] arr, int N, int depth){
        if(depth == arr.length){
            for(int e : arr){
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(arr, N, depth+1);
                visited[i] = false;
            }
        }
    }
}
