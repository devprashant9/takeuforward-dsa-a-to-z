import java.util.List;

public class CycleDirectedGraph {

    public boolean isCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < pathVisited.length; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> adj, int start, boolean[] visited, boolean[] pathVisited) {
        visited[start] = true;
        pathVisited[start] = true;

        for (int i : adj.get(start)) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, pathVisited)) {
                    return true;
                } else if (pathVisited[i]) {
                    return true;
                }
            }
        }

        pathVisited[start] = false;
        return false;

    }
}