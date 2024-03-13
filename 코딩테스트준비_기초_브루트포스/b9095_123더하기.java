package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9095_123더하기 {
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            dfs(n,0);
            System.out.println(count);
            count = 0;
        }
    }
    private static void dfs(int n, int current){
        if(n < current) return;
        if(current == n) {
            count++;
            return;
        }
        dfs(n,current+1);
        dfs(n,current+2);
        dfs(n,current+3);
    }
}
