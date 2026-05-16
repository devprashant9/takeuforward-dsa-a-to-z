import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixBFS {

    public static List<Integer> bfsTraversal(int[][] graph, int start) {
        List<Integer> bfs = new ArrayList<>();

        int V = graph.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.remove();

            bfs.add(u);

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] == 1) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }

        return bfs;
    }

}