import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class sw1
{
    /*
       사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
       이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            Map<Integer, List<Integer>> graph = createGraph();
            System.out.println(minTriangleGimbap(graph, s,e));
        }
        sc.close();
    }
    private static Map<Integer, List<Integer>> createGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int count = 1;

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                List<Integer> neighbors = new ArrayList<>();
                if (j != 0) neighbors.add(count - 1);
                if (j != i - 1) neighbors.add(count + 1);
                if (count > i) neighbors.add(count - i);
                if (count <= 10) neighbors.add(count + i);
                graph.put(count, neighbors);
                count++;
            }
        }
        return graph;
    }

    private static int minTriangleGimbap(Map<Integer, List<Integer>> graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == end) return depth;

                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}