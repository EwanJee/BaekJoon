package 코딩테스트준비_기초_브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6064_카잉달력1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(calculate(M, N, x, y));
        }
    }

    private static int calculate(int M, int N, int x, int y) {
        x--;
        y--;
        for (int i = x; i < (N * M); i += M) {
            if ((i % N == y)) {
                return i + 1;
            }
        }
        return -1;
    }
}



