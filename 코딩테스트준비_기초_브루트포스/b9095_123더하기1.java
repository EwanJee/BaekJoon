package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9095_123더하기1 {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(cal(n));
            count = 0;
        }
    }

    private static int cal(int n) {
        dfs(n, 0);
        return count;
    }

    private static void dfs(int n, int current) {
        if (current < n) {
            dfs(n,current+1);
            dfs(n,current+2);
            dfs(n,current+3);
        }
        else if (current == n) count++;
    }
}
