import java.util.*;
import java.io.*;
public class b1303_전투 {
    static boolean[][] visited;
    static char[][] arr;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int white= 0;
    static int black= 0;
    static int count = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<N; j++){
                char ch = str.charAt(j);
                arr[i][j] = ch;
            }
        }
        for(int i=0; i<M; i++){
             for(int j=0; j<N; j++){
                 if(!visited[i][j]){
                     if(arr[i][j] == 'W'){
                         int num = bfs(i,j,'W');
                         white += num*num;
                     }
                     else{
                         int num = bfs(i,j,'B');
                         black += num * num;
                     }
                 }
             }
        }
        sb.append(white).append(" ").append(black);
        System.out.println(sb);
    }
    static int bfs(int x, int y, char ch){
        count = 1;
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(visited[nx][ny] || arr[nx][ny] != ch) continue;
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count ++;
                }
            }
        }
        return count;
    }
}
