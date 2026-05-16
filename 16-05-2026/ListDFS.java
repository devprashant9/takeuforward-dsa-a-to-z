import java.util.ArrayList;
import java.util.List;

public class ListDFS {

    public static List<Integer> dfsTraversal(List<List<Integer>> graph, int start) {
        List<Integer> dfs = new ArrayList<>();

        helper(graph, start, new boolean[graph.size()], dfs);
        return dfs;
    }

    public static void helper(List<List<Integer>> graph, int start, boolean[] visited, List<Integer> dfs) {
        dfs.add(start);
        visited[start] = true;

        for (int v : graph.get(start)) {
            if (!visited[v]) {
                helper(graph, v, visited, dfs);
            }
        }
    }
}