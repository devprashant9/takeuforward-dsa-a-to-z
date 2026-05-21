import java.util.List;
import java.util.Stack;

public class TopoSort {

    public int[] topoSort(int V, List<List<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, st);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    public static void dfs(List<List<Integer>> adj, int start, boolean[] visited, Stack<Integer> st) {
        visited[start] = true;

        for (int i : adj.get(start)) {
            if (!visited[i]) {
                dfs(adj, i, visited, st);
            }
        }

        st.push(start);
    }
}
