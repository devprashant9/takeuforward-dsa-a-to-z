import java.util.Arrays;

public class GridUniquePathsII {

    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        int m = mat.length;
        int n = mat[0].length;

        System.out.println(recursive(mat, 0, 0));

        int[][] dp = new int[m][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(dpSolution(mat, 0, 0, dp));

        System.out.println(tabulation(mat, m, n));
        System.out.println(tabulationOptimized(mat));
    }

    private static boolean checkBound(int[][] mat, int row, int col) {
        if (row < 0 || row >= mat.length)
            return false;
        if (col < 0 || col >= mat[0].length)
            return false;
        return true;
    }

    private static int recursive(int[][] mat, int row, int col) {
        if (!checkBound(mat, row, col)) {
            return 0;
        }

        if (mat[row][col] == 1) {
            return 0;
        }

        if (row == mat.length - 1 && col == mat[0].length - 1) {
            return 1;
        }

        int stepRight = recursive(mat, row, col + 1);
        int stepDown = recursive(mat, row + 1, col);

        return stepRight + stepDown;
    }

    private static int dpSolution(int[][] mat, int row, int col, int[][] dp) {
        if (!checkBound(mat, row, col)) {
            return 0;
        }

        if (mat[row][col] == 1) {
            return 0;
        }

        if (dp[row][col] != -1)
            return dp[row][col];

        if (row == mat.length - 1 && col == mat[0].length - 1) {
            return 1;
        }

        int stepRight = dpSolution(mat, row, col + 1, dp);
        int stepDown = dpSolution(mat, row + 1, col, dp);

        return dp[row][col] = stepRight + stepDown;
    }

    private static int tabulation(int[][] mat, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Destination
        if (mat[m - 1][n - 1] == 1) {
            return 0;
        }

        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1)
                    continue;

                if (mat[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int stepRight = dp[i][j + 1];
                int stepDown = dp[i + 1][j];

                dp[i][j] = stepRight + stepDown;
            }
        }
        return dp[0][0];
    }

    private static int tabulationOptimized(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (mat[0][0] == 1)
            return 0;
        if (mat[m - 1][n - 1] == 1)
            return 0;

        int[] nextRow = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            int[] currRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) {
                    currRow[j] = 1;
                    continue;
                }

                if (mat[i][j] == 1) {
                    currRow[j] = 0;
                    continue;
                }

                int right = (j + 1 < n) ? currRow[j + 1] : 0;
                int down = nextRow[j];

                currRow[j] = right + down;
            }
            nextRow = currRow;
        }
        return nextRow[0];
    }
}