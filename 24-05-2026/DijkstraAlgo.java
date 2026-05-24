import java.util.*;

class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        // adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // edges = [u, v, w]
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // remove if directed graph
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int d = curr.dist;

            // skip outdated entries
            if (d > dist[node])
                continue;

            for (Pair nei : adj.get(node)) {

                int adjNode = nei.node;
                int wt = nei.dist;

                if (dist[node] + wt < dist[adjNode]) {

                    dist[adjNode] = dist[node] + wt;

                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }
}