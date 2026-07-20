import java.util.*;

class NumberOfIslandII {

    static class DSU {
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

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return false;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            return true;
        }
    }

    public List<Integer> numOfIslands(int n, int m, int[][] A) {

        DSU dsu = new DSU(n * m);

        boolean[][] land = new boolean[n][m];

        List<Integer> ans = new ArrayList<>();

        int islands = 0;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int[] op : A) {

            int r = op[0];
            int c = op[1];

            // Already land
            if (land[r][c]) {
                ans.add(islands);
                continue;
            }

            land[r][c] = true;
            islands++;

            int node = r * m + c;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                if (!land[nr][nc])
                    continue;

                int adjNode = nr * m + nc;

                if (dsu.union(node, adjNode))
                    islands--;
            }

            ans.add(islands);
        }

        return ans;
    }
}