package leetcode.graph;
import java.util.*;

public class l797_AllPathsFromSourcetoTarget {
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i=0; i<graph.length; i++) {
                list.add(new ArrayList<>());
                for (int j=0; j<graph[i].length; j++) {
                    list.get(i).add(graph[i][j]);
                }
            }
            int end = graph.length - 1;
            List<List<Integer>> answer = new ArrayList<>();
            List<Integer> output = new ArrayList<>();
            output.add(0);
            dfs(0, end, list, output, answer);

            return answer;
        }
        private void dfs (int i, int end, List<List<Integer>> list, List<Integer> output, List<List<Integer>> answer) {
            if (i == end) {
                answer.add(new ArrayList(output));
                return;
            }
            List<Integer> subs = list.get(i);
            for (int sub : subs) {
                output.add(sub);
                dfs(sub, end, list, output, answer);
                output.remove(Integer.valueOf(sub));
            }
        }
    }
}
