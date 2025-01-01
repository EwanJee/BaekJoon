package leetcode.graph;

import java.util.*;

public class l1129_ShortestPathWithAlternatingColors {

    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int[] answer = new int[n];
            Arrays.fill(answer, -1); // 초기화

            List<List<Integer>> redAdj = new ArrayList<>();
            List<List<Integer>> blueAdj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                redAdj.add(new ArrayList<>());
                blueAdj.add(new ArrayList<>());
            }

            for (int[] edge : redEdges) redAdj.get(edge[0]).add(edge[1]);
            for (int[] edge : blueEdges) blueAdj.get(edge[0]).add(edge[1]);

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0}); // 빨간색 시작
            queue.offer(new int[]{0, 1}); // 파란색 시작

            boolean[][] visited = new boolean[n][2];
            visited[0][0] = visited[0][1] = true;
            answer[0] = 0;

            int level = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                level++;
                for (int i = 0; i < size; i++) {
                    int[] node = queue.poll();
                    int u = node[0];
                    int color = node[1];

                    List<Integer> nextEdges = color == 0 ? blueAdj.get(u) : redAdj.get(u);
                    int nextColor = 1 - color;

                    for (int v : nextEdges) {
                        if (!visited[v][nextColor]) {
                            visited[v][nextColor] = true;
                            queue.offer(new int[]{v, nextColor});
                            if (answer[v] == -1) answer[v] = level;
                        }
                    }
                }
            }

            return answer;
        }
    }

}
