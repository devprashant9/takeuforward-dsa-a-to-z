import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgoBFS {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean checkBound(int[][] graph, int m, int n) {
        if (m < 0 || m >= graph.length) {
            return false;
        }

        if (n < 0 || n >= graph[0].length) {
            return false;
        }

        return true;
    }

    public void bfs(int[][] graph, int sr, int sc, int newColour) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        int originalColour = graph[sr][sc];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr, sc));
        graph[sr][sc] = newColour;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.key;
            int c = p.value;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (checkBound(graph, nr, nc) && graph[nr][nc] == originalColour) {
                    graph[nr][nc] = newColour;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public int[][] floodFill(int[][] graph, int sr, int sc, int newColour) {
        if (graph[sr][sc] == newColour) {
            return graph;
        }

        bfs(graph, sr, sc, newColour);
        return graph;
    }

}