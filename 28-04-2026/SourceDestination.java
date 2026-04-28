import java.util.ArrayList;
import java.util.List;

public class SourceDestination {

    public static void gridTraversal(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        helper(n, 0, 0, visited, grid, new ArrayList<>());
    }

    public static void helper(int n, int r, int c, boolean[][] visited, int[][] path, List<Integer> ans) {

        // Base Case: Movement is Outside Grid
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return;
        }

        if (visited[r][c]) {
            return;
        }

        // Choose The Path
        visited[r][c] = true;
        ans.add(path[r][c]);

        // Base Case: Destination Reached
        if (r == n - 1 && c == n - 1) {
            System.out.println(ans);
        } else {
            helper(n, r, c + 1, visited, path, ans);
            helper(n, r + 1, c, visited, path, ans);
            helper(n, r, c - 1, visited, path, ans);
            helper(n, r - 1, c, visited, path, ans);
        }

        ans.remove(ans.size() - 1);
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 10, 20, 30 },
                { 40, 50, 60 },
                { 70, 80, 90 }
        };

        gridTraversal(grid);
    }
}