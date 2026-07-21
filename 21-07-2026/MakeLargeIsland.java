import java.util.*;

public class MakeLargeIsland {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] == node)
                return node;

            return parent[node] = find(parent[node]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // Step 1: Connect all existing islands
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0)
                    continue;

                int node = r * n + c;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {

                        int adjNode = nr * n + nc;
                        dsu.union(node, adjNode);
                    }
                }
            }
        }

        int ans = 0;

        // Step 2: Try converting every 0 into 1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1)
                    continue;

                HashSet<Integer> set = new HashSet<>();

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        set.add(dsu.find(nr * n + nc));
                    }
                }

                int size = 1;

                for (int parent : set)
                    size += dsu.size[parent];

                ans = Math.max(ans, size);
            }
        }

        // Step 3: Handle all-1 grid
        for (int i = 0; i < n * n; i++) {
            if (dsu.find(i) == i)
                ans = Math.max(ans, dsu.size[i]);
        }

        return ans;
    }
}