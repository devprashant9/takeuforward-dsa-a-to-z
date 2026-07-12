import java.util.*;

class PrimsAlgorithm {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[V];

        // {weight, node}
        pq.offer(new int[] { 0, 0 });

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            if (visited[node])
                continue;

            visited[node] = true;
            sum += wt;

            for (List<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edgeWt = edge.get(1);

                if (!visited[adjNode]) {
                    pq.offer(new int[] { edgeWt, adjNode });
                }
            }
        }

        return sum;
    }
}