public class GridTraversalDFS {

    public static void gridDFS(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1 && !visited[r][c]) {
                    dfs(grid, r, c, visited);
                    islands++;
                }

            }
        }

        System.out.println("Islands = " + islands);
    }

    public static void dfs(int[][] grid, int r, int c, boolean[][] visited) {

        // boundary + invalid check
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
                visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;

        // explore 4 directions
        dfs(grid, r + 1, c, visited); // down
        dfs(grid, r - 1, c, visited); // up
        dfs(grid, r, c + 1, visited); // right
        dfs(grid, r, c - 1, visited); // left
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 0 }
        };

        gridDFS(grid);
    }
}