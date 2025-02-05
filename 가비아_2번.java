
import java.util.*;

public class 가비아_2번 {
    public int[] solution(int N, int[] A, int[] B) {
        // 각 구간을 정렬하여 항상 [min, max] 형태로 유지
        int[][] intervals = new int[N][3]; // [start, end, index] 저장
        for (int i = 0; i < N; i++) {
            intervals[i][0] = Math.min(A[i], B[i]);
            intervals[i][1] = Math.max(A[i], B[i]);
            intervals[i][2] = i; // 원래 인덱스 저장
        }

        // 시작점을 기준으로 정렬
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Union-Find (Disjoint Set) 활용
        UnionFind uf = new UnionFind(N);

        // 그룹을 만들기 위해 겹치는 구간을 합친다.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 겹치는 조건: intervals[j][0] <= intervals[i][1]
                if (intervals[j][0] <= intervals[i][1]) {
                    uf.union(intervals[i][2], intervals[j][2]);
                } else {
                    break; // 정렬되어 있으므로 더 이상 확인할 필요 없음
                }
            }
        }

        // 그룹의 크기 계산
        int[] groupSize = new int[N];
        for (int i = 0; i < N; i++) {
            groupSize[uf.find(i)]++; // 루트 노드 기준 그룹 크기 증가
        }

        // 결과 생성
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = groupSize[uf.find(i)];
        }

        return result;
    }

    // Union-Find (Disjoint Set) 구현
    class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // 경로 압축
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
