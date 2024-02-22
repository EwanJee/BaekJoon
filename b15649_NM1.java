import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15649_NM1 {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        start(N,M,0);
    }
    private static void start(int N, int M, int depth){
        if(depth == M){
            for(int a : arr){
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                start(N,M,depth+1);
                visited[i] = false;
            }
        }
    }
}
