import java.util.List;

public class CycleDetectionDFS {

    public boolean dfs(List<List<Integer>> adj, int parent, int start, boolean[] visited) {

        visited[start] = true;

        for (int i : adj.get(start)) {
            if (!visited[i]) {
                if (dfs(adj, start, i, visited)) {
                    return true;
                }
            } else if (parent != i) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, -1, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

}