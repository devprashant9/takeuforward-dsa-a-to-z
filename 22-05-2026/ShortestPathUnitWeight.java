import java.util.*;

public class ShortestPathUnitWeight {

    public int[] shortestPath(int[][] edges, int N, int M) {

        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // distance array
        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        // BFS
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adj.get(node)) {

                // not visited
                if (dist[neigh] == -1) {
                    dist[neigh] = dist[node] + 1;
                    q.offer(neigh);
                }
            }
        }

        return dist;
    }
}