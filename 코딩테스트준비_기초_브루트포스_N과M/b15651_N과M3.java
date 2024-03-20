package 코딩테스트준비_기초_브루트포스_N과M;
import java.util.*;
import java.io.*;
public class b15651_N과M3 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        dfs(0,N,M,arr);
        System.out.println(sb);
    }
    private static void dfs(int depth, int N, int M, int[] arr){
        if(depth == M){
            for(int e : arr){
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            dfs(depth+1,N,M,arr);
        }
    }
}
