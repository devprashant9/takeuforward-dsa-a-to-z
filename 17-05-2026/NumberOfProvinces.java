import java.util.List;

public class NumberOfProvinces {

    public void dfs(List<List<Integer>> adj, int start, boolean[] visited) {
        visited[start] = true;

        for (int i : adj.get(start)) {
            if (!visited[i]) {
                dfs(adj, i, visited);
            }
        }
    }

    public int countProvinces(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                cnt++;
            }
        }
        return cnt;
    }
}