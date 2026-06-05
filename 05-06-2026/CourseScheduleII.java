import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int V, int[][] arr) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] edge : arr) {
            int course = edge[0];
            int prereq = edge[1];

            adj.get(prereq).add(course);
        }

        return topoSort(V, adj);
    }

    public int[] topoSort(int V, List<List<Integer>> adj) {

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, pathVisited, st)) {
                    return new int[0]; // cycle found
                }
            }
        }

        int[] ans = new int[V];
        int idx = 0;

        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }

        return ans;
    }

    public static boolean dfs(
            List<List<Integer>> adj,
            int node,
            boolean[] visited,
            boolean[] pathVisited,
            Stack<Integer> st) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                if (dfs(adj, neighbour, visited, pathVisited, st)) {
                    return true;
                }
            } else if (pathVisited[neighbour]) {
                return true; // cycle detected
            }
        }

        pathVisited[node] = false;
        st.push(node);

        return false;
    }
}