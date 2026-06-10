import java.util.Arrays;

public class NinjaFriends {

    public static void main(String[] args) {
        int[][] mat = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 }
        };

        int m = mat.length;
        int n = mat[0].length;

       System.out.println(recursive(mat, 0, 0, n - 1));

        int[][][] dp = new int[m][n][n];
        for (int[][] r : dp) {
            for (int[] r1 : r) {
                Arrays.fill(r1, -1);
            }
        }

        System.out.println(dpSolution(mat, 0, 0, n - 1, dp));
    }

    private static boolean checkBound(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length &&
                col >= 0 && col < grid[0].length;
    }

    private static int recursive(int[][] grid, int row, int aliceCol, int bobCol) {
        // Bound Check
        if (!checkBound(grid, row, aliceCol) || !checkBound(grid, row, bobCol)) {
            return Integer.MIN_VALUE;
        }

        // Base Case: Last Can have 2 Scenarios
        if (row == grid.length - 1) {
            if (aliceCol == bobCol) {
                return grid[row][aliceCol];
            }

            return grid[row][aliceCol] + grid[row][bobCol];
        }

        // Any Other Cell Can Also have 2 Scenarios
        int currentChocolates;
        if (aliceCol == bobCol) {
            currentChocolates = grid[row][aliceCol];
        } else {
            currentChocolates = grid[row][aliceCol] + grid[row][bobCol];
        }

        int max = Integer.MIN_VALUE;
        for (int aliceMove = -1; aliceMove <= 1; aliceMove++) {
            for (int bobMove = -1; bobMove <= 1; bobMove++) {

                int future = recursive(grid, row + 1, aliceCol + aliceMove, bobCol + bobMove);
                max = Math.max(max, currentChocolates + future);
            }
        }

        return max;
    }

    private static int dpSolution(int[][] grid, int row, int aliceCol, int bobCol, int[][][] dp) {
        // Bound Check
        if (!checkBound(grid, row, aliceCol) || !checkBound(grid, row, bobCol)) {
            return Integer.MIN_VALUE;
        }

        if (dp[row][aliceCol][bobCol] != -1)
            return dp[row][aliceCol][bobCol];

        // Base Case: Last Can have 2 Scenarios
        if (row == grid.length - 1) {
            if (aliceCol == bobCol) {
                return grid[row][aliceCol];
            }

            return grid[row][aliceCol] + grid[row][bobCol];
        }

        // Any Other Cell Can Also have 2 Scenarios
        int currentChocolates;
        if (aliceCol == bobCol) {
            currentChocolates = grid[row][aliceCol];
        } else {
            currentChocolates = grid[row][aliceCol] + grid[row][bobCol];
        }

        int max = Integer.MIN_VALUE;
        for (int aliceMove = -1; aliceMove <= 1; aliceMove++) {
            for (int bobMove = -1; bobMove <= 1; bobMove++) {

                int future = dpSolution(grid, row + 1, aliceCol + aliceMove, bobCol + bobMove, dp);
                max = Math.max(max, currentChocolates + future);
            }
        }

        return dp[row][aliceCol][bobCol] = max;
    }
}