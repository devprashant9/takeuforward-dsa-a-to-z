import java.util.*;

class EventualSafeState {
    public int[] eventualSafeNodes(int V, int[][] adj) {

        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Build reverse graph and compute indegree
        for (int i = 0; i < V; i++) {
            indegree[i] = adj[i].length;

            for (int neighbour : adj[i]) {
                reverseGraph.get(neighbour).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int prev : reverseGraph.get(node)) {
                indegree[prev]--;

                if (indegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        Collections.sort(safeNodes);

        int[] ans = new int[safeNodes.size()];
        for (int i = 0; i < safeNodes.size(); i++) {
            ans[i] = safeNodes.get(i);
        }

        return ans;
    }
}