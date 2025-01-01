package leetcode.graph;

import java.util.*;

public class l1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<Integer>> list = new ArrayList<>();
            List<List<Integer>> answer = new ArrayList<>();
            for (int i=0; i<n; i++) {
                list.add(new ArrayList<>());
                answer.add(new ArrayList<>());
            }
            for (int[] connection : connections) {
                int from = connection[0];
                int to = connection[1];
                list.get(from).add(to);
                list.get(to).add(from);
            }
            boolean[] visited = new boolean[n];
            dfs(0,list, visited, answer);
            int count = 0;
            for (int i=0; i<connections.length; i++) {
                int from = connections[i][0];
                int to = connections[i][1];
                List<Integer> fromSubs = answer.get(from);
                if (fromSubs.contains(to)) {
                    count++;
                }
            }
            return count;
        }
        private void dfs(int node, List<List<Integer>> list, boolean[] visited, List<List<Integer>> answer) {
            visited[node] = true;
            List<Integer> subs = list.get(node);
            for (int i=0; i<subs.size(); i++) {
                int sub = subs.get(i);
                if (!visited[sub]){
                    answer.get(node).add(sub);
                    dfs(sub, list, visited, answer);
                }
            }
        }
    }
}
