import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MST {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(v1).add(new Pair(v2, weight));
            list.get(v2).add(new Pair(v1, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.offer(new Pair(1, 0)); // Start from node 1
        int answer = 0;
        int count = 0; // Count of edges in MST

        while (!pq.isEmpty()) {
            Pair start = pq.poll();
            int to = start.to;
            int cost = start.cost;

            if (visited[to]) continue; // 이미 방문한 정점이면 스킵

            visited[to] = true;
            answer += cost;
            count++;

            if (count == V) break; // 모든 정점을 방문하면 종료 (V-1개의 간선 선택됨)

            for (Pair next : list.get(to)) {
                if (!visited[next.to]) { // 방문하지 않은 정점만 추가
                    pq.offer(next);
                }
            }
        }

        System.out.println(answer);
    }

    static class Pair implements Comparable<Pair> {
        public int to;
        public int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
