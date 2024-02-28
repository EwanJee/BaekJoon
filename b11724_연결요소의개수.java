import java.util.*;
import java.io.*;
public class b11724_연결요소의개수 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int nodes, lines;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       nodes = Integer.parseInt(st.nextToken());
       lines = Integer.parseInt(st.nextToken());
       arr = new ArrayList[nodes+1];
       visited = new boolean[nodes+1];
       for(int i=1; i<nodes+1; i++){
           arr[i] = new ArrayList<>();
       }
       for(int i=0; i<lines; i++){
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           arr[start].add(end);
       }
       for(int i=1; i<nodes+1; i++){
           if(!visited[i]){
               count++;
               dfs(i);
           }
       }
       System.out.println(count);
    }
    private static void dfs(int current){
        if(!visited[current]){
            visited[current] = true;
            for(int i: arr[current]){
                if(!visited[i]){
                    dfs(i);
                }
            }
        }
    }
}
