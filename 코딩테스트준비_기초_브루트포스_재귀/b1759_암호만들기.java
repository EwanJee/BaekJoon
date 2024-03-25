package 코딩테스트준비_기초_브루트포스_재귀;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1759_암호만들기 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int alpha = Integer.parseInt(st.nextToken());
        String[] box = new String[alpha];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alpha; i++) {
            box[i] = st.nextToken();
        }
        Arrays.sort(box);
        boolean[] visited = new boolean[alpha];
        String[] arr = new String[number];
        solve(visited, box, arr, 0, number, 0, 0);
        System.out.println(sb);
    }

    private static void solve(boolean[] visited, String[] box, String[] arr, int depth, int max, int vowels, int consonants) {
        if (depth == max) {
            if (vowels >= 1 && consonants >= 2) {
                for (String e : arr) {
                    sb.append(e);
                }
                sb.append("\n");
            }
//            Arrays.sort(arr);
            return;
        }
        for (int i = 0; i < box.length; i++) {
            if (!visited[i]) {
//                if(depth>=1){
//                    if(box[i].compareTo(arr[depth-1]) < 0) continue;
//                }
                String e = box[i];
                arr[depth] = e;
                if (e.equals("a") || e.equals("e") || e.equals("i") || e.equals("o") || e.equals("u")) {
                    visited[i] = true;
                    solve(visited, box, arr, depth + 1, max, vowels + 1, consonants);
                    visited[i] = false;
                } else {
                    visited[i] = true;
                    solve(visited, box, arr, depth + 1, max, vowels, consonants + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
