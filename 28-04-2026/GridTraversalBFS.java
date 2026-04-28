import java.util.*;

public class GridTraversalBFS {

    public static void gridBFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1 && !visited[r][c]) {
                    bfs(grid, r, c, visited);
                    islands++;
                }

            }
        }

        System.out.println("Islands = " + islands);
    }

    public static void bfs(int[][] grid, int r, int c, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        visited[r][c] = true;

        int[][] dir = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] d : dir) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nc >= 0 &&
                        nr < grid.length && nc < grid[0].length &&
                        !visited[nr][nc] && grid[nr][nc] == 1) {

                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 0 }
        };

        gridBFS(grid);
    }
}