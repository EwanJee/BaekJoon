import java.io.*;
import java.util.*;
public class b2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }
    public static void bfs(int x, int y){
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];
                if(nextX >= 0 && nextX<N && nextY >=0 && nextY<M){
                    if(visited[nextX][nextY] || arr[nextX][nextY] == 0) continue;
                    q.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[cx][cy] + 1;
                }
            }
        }
    }

}
