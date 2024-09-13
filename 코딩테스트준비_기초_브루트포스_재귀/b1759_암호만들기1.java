package 코딩테스트준비_기초_브루트포스_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1759_암호만들기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] strings = new String[C];
        boolean[] visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            strings[i] = st.nextToken();
        }
        Arrays.sort(strings);
        dfs(strings, visited, new String[L], 0, -1, false, 0);
    }

    private static void dfs(String[] strings, boolean[] visited, String[] answer, int depth, int current, boolean hasVowel, int consonants) {
        if (depth == answer.length) {
            if (hasVowel && consonants>=2) {
                StringBuilder sb = new StringBuilder();
                for (String s : answer) {
                    sb.append(s);
                }
                System.out.println(sb);
            }
            return;
        }
        for (int i = current + 1; i < strings.length; i++) {
            if (!visited[i]) {
                answer[depth] = strings[i];
                visited[i] = true;
                if (strings[i].equals("a") || strings[i].equals("e") || strings[i].equals("i") || strings[i].equals("o") || strings[i].equals("u")) {
                    dfs(strings, visited, answer, depth + 1, i, true, consonants);
                } else {
                    dfs(strings, visited, answer, depth + 1, i, hasVowel, consonants+1);
                }
                visited[i] = false;
            }
        }
    }
}
