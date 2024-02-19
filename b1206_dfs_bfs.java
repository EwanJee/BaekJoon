import java.util.*;
import java.io.*;
public class b1206_dfs_bfs {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node,line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken()); // 정점의 개수
        line = Integer.parseInt(st.nextToken()); // 간선의 개수
        start = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        check = new boolean[node+1];
        arr = new int[node+1][node+1];

        for(int i=0; i<line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {

        check[start] = true;
        sb.append(start).append(" ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;
        sb.append(start).append(" ");

        while(!q.isEmpty()) {

            start = q.poll();

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }


    }
}
