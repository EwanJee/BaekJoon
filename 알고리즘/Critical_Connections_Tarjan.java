package 알고리즘;

import java.util.*;

public class Critical_Connections_Tarjan {
    class Solution {
        List<List<Integer>> conn = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int id = 1;
        int[] disc, low;

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            disc = new int[n];
            low = new int[n];
            for (int i = 0; i < n; i++) {
                conn.add(new ArrayList<>());
            }
            for (int i = 0; i < connections.size(); i++) {
                List<Integer> list = connections.get(i);
                int from = list.get(0);
                int to = list.get(1);
                conn.get(from).add(to);
                conn.get(to).add(from);
            }
            dfs(0, -1);
            return ans;
        }

        public void dfs(int current, int prev) {
            disc[current] = id; // 현재 노드의 discovery time 설정
            low[current] = id; // 현재 노드의 low 값을 초기화
            id++; // 방문 순서를 증가시킴

            List<Integer> list = conn.get(current);
            for (int next : list) {
                if (next == prev) continue; // 이전 노드는 다시 방문하지 않음

                if (disc[next] == 0) { // 아직 방문하지 않은 노드라면
                    dfs(next, current); // DFS로 재귀 호출
                    low[current] = Math.min(low[current], low[next]);

                    // Critical Connection 조건 확0인
                    if (low[next] > disc[current]) {
                        ans.add(List.of(current, next)); // Critical Connection 저장
                    }
                } else { // 이미 방문한 노드라면
                    low[current] = Math.min(low[current], disc[next]);
                }
            }
        }
    }
}
