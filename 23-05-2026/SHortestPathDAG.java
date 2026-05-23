import java.util.*;

class ShortestPathDAG {

    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        // topo sort using DFS
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, st);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // source = 0
        dist[0] = 0;

        // process topo order
        while (!st.isEmpty()) {

            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {

                for (Pair it : adj.get(node)) {

                    int v = it.v;
                    int wt = it.wt;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // unreachable nodes = -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    static void topoSort(int node,
            ArrayList<ArrayList<Pair>> adj,
            boolean[] visited,
            Stack<Integer> st) {

        visited[node] = true;

        for (Pair it : adj.get(node)) {

            if (!visited[it.v]) {
                topoSort(it.v, adj, visited, st);
            }
        }

        st.push(node);
    }
}