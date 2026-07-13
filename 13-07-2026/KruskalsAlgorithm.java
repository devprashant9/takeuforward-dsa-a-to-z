import java.util.*;

public class KruskalsAlgorithm {

    static class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DisjointSet {
        int[] parent;
        int[] size;

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

    public static int spanningTree(int V, List<List<List<Integer>>> adj) {

        List<Edge> edges = new ArrayList<>();

        // Build edge list
        for (int u = 0; u < V; u++) {
            for (List<Integer> neighbour : adj.get(u)) {
                int v = neighbour.get(0);
                int wt = neighbour.get(1);

                edges.add(new Edge(u, v, wt));
            }
        }

        // Sort by edge weight
        edges.sort(Comparator.comparingInt(e -> e.wt));

        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int wt = edge.wt;

            if (ds.findParent(u) != ds.findParent(v)) {
                mstWeight += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWeight;
    }
}