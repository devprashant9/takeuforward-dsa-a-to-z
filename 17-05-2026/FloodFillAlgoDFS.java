public class FloodFillAlgoDFS {

    public void dfs(int[][] graph, int sr, int sc, int oldColour, int newColour) {
        if (sr < 0 || sr >= graph.length || sc < 0 || sc >= graph[0].length || graph[sr][sc] != oldColour) {
            return;
        }

        graph[sr][sc] = newColour;

        dfs(graph, sr + 1, sc, oldColour, newColour);
        dfs(graph, sr - 1, sc, oldColour, newColour);
        dfs(graph, sr, sc + 1, oldColour, newColour);
        dfs(graph, sr, sc - 1, oldColour, newColour);
    }

    public int[][] floodFill(int[][] graph, int sr, int sc, int newColour) {
        if (graph[sr][sc] == newColour) {
            return graph;
        }

        dfs(graph, sr, sc, graph[sr][sc], newColour);
        return graph;
    }
}

// BFS Can Also Solve This