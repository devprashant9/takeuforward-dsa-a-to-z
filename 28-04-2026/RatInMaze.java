public class RatInMaze {

    public static void ratInMaze(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        helper(maze.length, 0, 0, visited, maze, "");
    }

    public static void helper(int n, int r, int c, boolean[][] visited, int[][] path, String s) {

        if (r < 0 || c < 0 || r >= n || c >= n) {
            return;
        }

        if (visited[r][c] || path[r][c] == 0) {
            return;
        }

        visited[r][c] = true;

        if (r == n - 1 && c == n - 1) {
            System.out.println(s);
        } else {
            helper(n, r, c + 1, visited, path, s + "R");
            helper(n, r + 1, c, visited, path, s + "D");
            helper(n, r, c - 1, visited, path, s + "L");
            helper(n, r - 1, c, visited, path, s + "U");

        }

        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        ratInMaze(maze);
    }
}
