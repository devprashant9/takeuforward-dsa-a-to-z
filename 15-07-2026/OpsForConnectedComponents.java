class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
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

class OpsForConnectedComponents {
    public int solve(int n, int[][] Edge) {
        if (Edge.length < n - 1)
            return -1;

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : Edge) {
            ds.unionBySize(edge[0], edge[1]);
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i)
                components++;
        }

        return components - 1;
    }
}