package leetcode.graph;

import java.util.List;

public class l841_KeysAndRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];
            dfs(rooms,visited,0);
            for (boolean each : visited) {
                if (!each) return false;
            }
            return true;
        }
        private void dfs(List<List<Integer>> rooms, boolean[] visited, int start) {
            visited[start] = true;
            List<Integer> keys = rooms.get(start);
            for (int key : keys){
                if (!visited[key]) {
                    dfs(rooms, visited, key);
                }
            }
        }
    }
}
