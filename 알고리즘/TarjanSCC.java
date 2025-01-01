package 알고리즘;

import java.util.*;

public class TarjanSCC {
    private List<List<Integer>> graph;
    private List<List<Integer>> sccs;
    private int[] ids;
    private int[] low;
    private boolean[] onStack;
    private Stack<Integer> stack;
    private int id;

    public TarjanSCC(List<List<Integer>> connection) {
        this.graph = connection;
        int n = graph.size();
        this.sccs = new ArrayList<>();
        this.ids = new int[n];
        Arrays.fill(ids, -1);
        this.low = new int[n];
        this.onStack = new boolean[n];
        this.stack = new Stack<>();
        this.id = 0;

        // Run Tarjan's algorithm for each node
        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) {
                dfs(i);
            }
        }
    }

    private void dfs(int at) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        for (int to : graph.get(at)) {
            if (ids[to] == -1) {
                dfs(to);
                low[at] = Math.min(low[at], low[to]);
            } else if (onStack[to]) {
                low[at] = Math.min(low[at], ids[to]);
            }
        }

        // On root node, pop the stack and generate an SCC
        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == at) break;
            }
            sccs.add(scc);
        }
    }

    public List<List<Integer>> getSCCs() {
        return sccs;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> connection = new ArrayList<>();
        connection.add(Arrays.asList(1));       // Node 0 -> 1
        connection.add(Arrays.asList(2));       // Node 1 -> 2
        connection.add(Arrays.asList(0, 3));    // Node 2 -> 0, 3
        connection.add(Arrays.asList(4));       // Node 3 -> 4
        connection.add(Arrays.asList(5, 6));    // Node 4 -> 5, 6
        connection.add(Arrays.asList(3));       // Node 5 -> 3
        connection.add(Collections.emptyList());// Node 6 has no outgoing edges

        TarjanSCC tarjan = new TarjanSCC(connection);
        List<List<Integer>> sccs = tarjan.getSCCs();

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
