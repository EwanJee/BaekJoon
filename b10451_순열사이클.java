import java.io.*;
import java.util.*;
public class b10451_순열사이클 {
    static int[] nodes;
    static boolean[] visited;
    static int count  = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            nodes = new int[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                int e = Integer.parseInt(st.nextToken());
                nodes[i] = e;
            }
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    dfs(i);
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
    private static void dfs(int start){
        if(!visited[start]){
            visited[start] = true;
            dfs(nodes[start]);
        }
        else{
            count++;
        }
    }
}
