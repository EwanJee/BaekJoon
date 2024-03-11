import java.util.*;
import java.io.*;
public class b1260_dfs_bfs {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[vertices+1];
        list = new ArrayList[vertices+1];
        for(int i=0; i<=vertices; i++){
            list[i] = new ArrayList<>();
        }
        sb = new StringBuilder();
        for(int i=0; i<edges; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for(int i=0; i<list.length; i++){
            Collections.sort(list[i]);
        }
        dfs(start);
        visited = new boolean[vertices+1];
        sb.append("\n");
        bfs(start);
        System.out.println(sb);
    }
    private static void dfs(int start){
        if(visited[start])
            return;
        else{
            sb.append(start).append(" ");
            visited[start] = true;
            for(int i=0; i<list[start].size(); i++){
                if(!visited[list[start].get(i)]){
                    dfs(list[start].get(i));
                }
            }
        }
    }
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");
            for(int i=0; i<list[current].size(); i++){
                if(!visited[list[current].get(i)]){
                    visited[list[current].get(i)] = true;
                    q.offer(list[current].get(i));
                }
            }
        }
    }
}
