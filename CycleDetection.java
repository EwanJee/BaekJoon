import java.util.List;

public class CycleDetection {
    static boolean isCycle = false;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
                List.of(1, 2),
                List.of(0, 2),
                List.of(0, 1)
        );
        solve(graph);
    }

    public static void solve(List<List<Integer>> graph) {
        visited = new boolean[graph.size()];
        finished = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, -1, graph, String.valueOf(i))) {
                    return; // 사이클 발견 시 즉시 종료
                }
            }
        }
        System.out.println("No cycle found.");
    }

    static boolean dfs(int current, int parent, List<List<Integer>> graph, String path) {
        visited[current] = true;

        for (int next : graph.get(current)) {
            if (next == parent) continue; // 부모 노드는 무시

            if (!visited[next]) {
                if (dfs(next, current, graph, path + " -> " + next)) {
                    return true; // 사이클이 발견되면 즉시 종료
                }
            } else if (!finished[next]) {
                System.out.println("Cycle found: " + path + " -> " + next);
                return true; // 사이클 발견
            }
        }
        finished[current] = true;
        return false;
    }
}
