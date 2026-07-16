import java.util.*;

class Solution {

    static class DisjointSet {
        int[] parent, size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

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

    public int maxRemove(int[][] stones, int n) {

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        int totalNodes = maxRow + maxCol + 2;
        DisjointSet ds = new DisjointSet(totalNodes);

        HashSet<Integer> usedNodes = new HashSet<>();

        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1;

            ds.unionBySize(rowNode, colNode);

            usedNodes.add(rowNode);
            usedNodes.add(colNode);
        }

        int components = 0;

        for (int node : usedNodes) {
            if (ds.findParent(node) == node)
                components++;
        }

        return n - components;
    }
}