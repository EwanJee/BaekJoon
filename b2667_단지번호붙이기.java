import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class b2667_단지번호붙이기 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] houses;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int index = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                int a = s.charAt(j) - '0';
                arr[i][j] = a;
            }
        }
        houses = new int[N*N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    index++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(houses);
        System.out.println(index);
        for (int house : houses) {
            if (house != 0) {
                System.out.println(house);
            }
        }


    }
    private static void dfs(int x, int y){
        houses[index]++;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(arr[nx][ny] == 1 && !visited[nx][ny])
                    dfs(nx,ny);
            }
        }
    }
}
