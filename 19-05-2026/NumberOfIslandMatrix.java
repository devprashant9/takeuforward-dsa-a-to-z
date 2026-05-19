import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandMatrix {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public int countIsland(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                    bfs(graph, q, visited);

                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean checkBound(int[][] graph, int r, int c) {
        if (r < 0 || r > graph.length) {
            return false;
        }

        if (c < 0 || c > graph[0].length) {
            return false;
        }

        return true;
    }

    public void bfs(int[][] graph, Queue<Pair> q, boolean[][] visited) {
        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (checkBound(graph, r, c) && graph[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}