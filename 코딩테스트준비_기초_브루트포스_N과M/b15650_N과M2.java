package 코딩테스트준비_기초_브루트포스_N과M;
import java.io.*;
import java.util.*;
public class b15650_N과M2 {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[0] = i;
                dfs(M,1,i);
                visited[i] = false;
            }
        }
        System.out.println(sb);
    }
    private static void dfs(int M, int depth, int current){
        int N = visited.length-1;
        if(depth == M){
            for(int e : arr){
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<= N; i++){
            if(!visited[i] && i>current){
                visited[i] = true;
                arr[depth] = i;
                dfs(M,depth+1,i);
                visited[i] = false;
            }
        }
    }
}
