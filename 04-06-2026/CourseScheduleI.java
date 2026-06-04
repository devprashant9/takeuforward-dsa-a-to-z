import java.util.*;
public class CourseScheduleI {

    public boolean canFinish(int N, int[][] arr) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : arr) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, pathVisited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node,
            List<List<Integer>> adj,
            boolean[] visited,
            boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                if (hasCycle(neighbour, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}