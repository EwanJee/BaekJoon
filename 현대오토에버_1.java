import java.io.*;
import java.util.*;

public class 현대오토에버_1 {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (map.get(i).size() == 0) {
                count++;
                visited[i] = true;
            }
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count += bfs(visited, i);
            }
        }

        System.out.println(count);
    }

    static int bfs(boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int c = 0;
        boolean isCycle = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            visited[current] = true;
            c++;

            if (map.get(current).size() != 2) {
                isCycle = false;
            }

            for (int next : map.get(current)) {
                if (!visited[next]) {
                    q.offer(next);
                }
            }
        }

        if (isCycle) {
            return c / 2;
        } else {
            if (c % 2 == 0) {
                return c / 2;
            } else {
                return c / 2 + 1;
            }
        }
    }
}