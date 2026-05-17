import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionBFS {

    public class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }

    }

    public boolean bfs(List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, -1));
        visited[start] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.node;
            int parent = p.parent;

            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Pair(i, node));
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}