import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numberOfEnclaves(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        bfs(mat, m, n);

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public Queue<Pair> markStartingPoint(int[][] graph, int m, int n) {
        Queue<Pair> q = new LinkedList<>();

        // top and bottom row
        int r = m - 1;
        for (int col = 0; col < n; col++) {
            if (graph[0][col] == 1) {
                graph[0][col] = 2; // mark safe
                q.add(new Pair(0, col));
            }

            if (graph[r][col] == 1) {
                graph[r][col] = 2; // mark safe
                q.add(new Pair(r, col));
            }
        }

        // left and right column
        int c = n - 1;
        for (int row = 0; row < m; row++) {
            if (graph[row][0] == 1) {
                graph[row][0] = 2; // mark safe
                q.add(new Pair(row, 0));
            }

            if (graph[row][c] == 1) {
                graph[row][c] = 2; // mark safe
                q.add(new Pair(row, c));
            }
        }
        return q;
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

    public void bfs(int[][] graph, int m, int n) {
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        Queue<Pair> q = markStartingPoint(graph, m, n);

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (checkBound(graph, nr, nc) && graph[nr][nc] == 0) {
                    graph[nr][nc] = 2;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}