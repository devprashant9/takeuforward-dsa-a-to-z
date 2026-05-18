import java.util.LinkedList;
import java.util.Queue;

public class NearestDistanceZeroOne {

    static class Node {
        int row;
        int col;
        int step;

        Node(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public static int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return bfs(grid, m, n);
    }

    public static Queue<Node> markStartingPoint(int[][] graph, int m, int n, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        return q;
    }

    public static boolean boundCheck(int[][] graph, int m, int n) {
        if (m < 0 || m >= graph.length) {
            return false;
        }

        if (n < 0 || n >= graph[0].length) {
            return false;
        }

        return true;
    }

    public static int[][] bfs(int[][] graph, int m, int n) {

        // check direction
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        // ans graph
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        // store starting points
        Queue<Node> q = markStartingPoint(graph, m, n, visited);

        while (!q.isEmpty()) {
            Node node = q.remove();
            int r = node.row;
            int c = node.col;
            int step = node.step;

            ans[r][c] = step;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (boundCheck(graph, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, step + 1));
                }
            }
        }
        return ans;
    }
}