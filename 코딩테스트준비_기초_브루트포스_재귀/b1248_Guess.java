package 코딩테스트준비_기초_브루트포스_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1248_Guess {
    /**
     * 2초
     * n = 20
     * n^7까지 가능. 시간복잡도 신경 안써도 됨
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int characters = n * (n + 1) / 2;
        String[][] map = new String[characters][characters];
        String str = br.readLine();
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map[i][j] = str.charAt(index) + "";
                index++;
            }
        }
        int[] answer = new int[n];
        solve(map, answer, n, 0);
    }

    private static void solve(String[][] map, int[] answer, int N, int depth) {
        if (depth == N){
            for (int each : answer) {
                System.out.print(each + " ");
            }
            System.exit(0);
        }
        for (int i = -10; i < 11; i++) {
            answer[depth] = i;
            if (check(map, answer, N, depth)){
                solve(map, answer, N, depth + 1);
            }
        }
    }

    private static boolean check(String[][] map, int[] answer, int N, int depth) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += answer[j];
                if (map[i][j].equals("+") && sum > 0) continue;
                else if (map[i][j].equals("-") && sum < 0) continue;
                else if (map[i][j].equals("0") && sum == 0) continue;
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
