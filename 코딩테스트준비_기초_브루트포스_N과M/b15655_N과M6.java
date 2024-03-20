package 코딩테스트준비_기초_브루트포스_N과M;
import java.util.*;
import java.io.*;
public class b15655_N과M6 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] box = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box);
        int[] arr = new int[M];
        boolean[] visited = new boolean[N];
        dfs(0,M,N,box,arr,visited);
        System.out.println((sb));
    }
    private static void dfs(int depth, int M, int N, int[] box, int[] arr, boolean[] visited){
        if(depth == M){
            for(int e : arr){
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]) {
                if(depth>0 && arr[depth-1]>box[i]) continue;
                arr[depth] = box[i];
                visited[i] = true;
                dfs(depth + 1, M, N, box, arr,visited);
                visited[i] = false;
            }
        }
    }
}
