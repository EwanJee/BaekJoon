package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class l1376_TimeNeededToInformAllEmployees {
    class Solution {
        private int minutes = 0;

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < manager.length; i++) {
                int m = manager[i];
                if (m == -1) continue;
                list.get(m).add(i);
            }
            dfs(headID, 0, list, informTime);
            return minutes;
        }

        private void dfs(int node, int currentTime, List<List<Integer>> list, int[] informTime) {
            minutes = Math.max(minutes, currentTime);
            for (int sub : list.get(node)) {
                dfs(sub, currentTime + informTime[node], list, informTime);
            }
        }
    }
}
