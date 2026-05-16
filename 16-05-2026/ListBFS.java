import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListBFS {

    public static List<Integer> bfsList(List<List<Integer>> graph, int start) {
        List<Integer> bfs = new ArrayList<>();

        int V = graph.size();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.remove();

            bfs.add(u);

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }

        return bfs;
    }
}