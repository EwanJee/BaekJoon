package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class l802_FindEventualSafeStates {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n]; // 0: unvisited, 1: visiting, 2: safe
            List<Integer> safeNodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (isSafe(graph, i, color)) {
                    safeNodes.add(i);
                }
            }
            return safeNodes;
        }

        private boolean isSafe(int[][] graph, int node, int[] color) {
            if (color[node] > 0) { // 이미 방문한 노드
                return color[node] == 2;
            }
            color[node] = 1; // 방문 중 표시
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 1 || !isSafe(graph, neighbor, color)) {
                    return false; // 순환이 발견된 경우
                }
            }
            color[node] = 2; // 안전한 노드로 표시
            return true;
        }
    }
}