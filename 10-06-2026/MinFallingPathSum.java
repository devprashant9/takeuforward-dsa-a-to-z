import java.util.Arrays;

public class MinFallingPathSum {

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 }
        };

        int recursiveMin = Integer.MAX_VALUE;
        for (int col = 0; col < mat[0].length; col++) {
            recursiveMin = Math.min(recursiveMin, recursive(mat, 0, col));
        }
        System.out.println(recursiveMin);

        int[][] dp = new int[mat.length][mat[0].length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        int memoizationMin = Integer.MAX_VALUE;
        for (int col = 0; col < mat[0].length; col++) {
            memoizationMin = Math.min(memoizationMin, dpSolution(mat, 0, col, dp));
        }
        System.out.println(memoizationMin);

        System.out.println(tabulation(mat));
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
            return Integer.MAX_VALUE / 2;
        }

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        int bottom = mat[row][col] + recursive(mat, row + 1, col);
        int bottomRight = mat[row][col] + recursive(mat, row + 1, col + 1);
        int bottomLeft = mat[row][col] + recursive(mat, row + 1, col - 1);

        return Math.min(bottom, Math.min(bottomRight, bottomLeft));
    }

    private static int dpSolution(int[][] mat, int row, int col, int[][] dp) {
        if (!checkBound(mat, row, col)) {
            return Integer.MAX_VALUE / 2;
        }

        if (dp[row][col] != -1)
            return dp[row][col];

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        int bottom = mat[row][col] + dpSolution(mat, row + 1, col, dp);
        int bottomRight = mat[row][col] + dpSolution(mat, row + 1, col + 1, dp);
        int bottomLeft = mat[row][col] + dpSolution(mat, row + 1, col - 1, dp);

        return dp[row][col] = Math.min(bottom, Math.min(bottomRight, bottomLeft));
    }

    private static int tabulation(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = mat[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int down = dp[i + 1][j];

                int downLeft = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE / 2;

                int downRight = (j < n - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE / 2;

                dp[i][j] = mat[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[0][col]);
        }
        return ans;
    }

    private static int tabulationOptimized(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] nextRow = new int[n];

        for (int j = 0; j < n; j++) {
            nextRow[j] = mat[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            int[] currentRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {

                int down = nextRow[j];

                int downLeft = (j > 0) ? nextRow[j - 1] : Integer.MAX_VALUE / 2;

                int downRight = (j + 1 < n) ? nextRow[j + 1] : Integer.MAX_VALUE / 2;

                currentRow[j] = mat[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
            nextRow = currentRow;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nextRow.length; i++) {
            ans = Math.min(ans, nextRow[i]);
        }
        return ans;
    }

}