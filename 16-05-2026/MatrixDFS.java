import java.util.ArrayList;
import java.util.List;

public class MatrixDFS {

    public static List<Integer> dfsTraversal(int[][] graph, int start) {
        List<Integer> dfs = new ArrayList<>();

        helper(graph, start, new boolean[graph.length], dfs);
        return dfs;
    }

    public static void helper(int[][] graph, int start, boolean[] visited, List<Integer> dfs) {
        dfs.add(start);
        visited[start] = true;

        for (int v = 0; v < graph.length; v++) {
            if (!visited[v] && graph[start][v] == 1) {
                helper(graph, v, visited, dfs);
            }
        }
    }
}