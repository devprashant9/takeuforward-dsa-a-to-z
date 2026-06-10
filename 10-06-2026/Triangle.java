import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        int[][] mat = {
                { 1 },
                { 4, 7 },
                { 4, 10, 50 },
                { -50, 5, 6, -100 }
        };

        int m = mat.length;
        int n = mat[m - 1].length;
        
        System.out.println(recursive(mat, 0, 0));

        int[][] dp = new int[m][n];
        for(int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(dpSolution(mat, 0, 0, dp));

        System.out.println(tabulation(mat));
        System.out.println(tabulationOptimized(mat));
    }

    private static int recursive(int[][] mat, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[row].length) {
            return Integer.MAX_VALUE / 2;
        }

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        return mat[row][col] + Math.min(recursive(mat, row + 1, col), recursive(mat, row + 1, col + 1));
    }

    private static int dpSolution(int[][] mat, int row, int col, int[][] dp) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[row].length) {
            return Integer.MAX_VALUE / 2;
        }

        if (dp[row][col] != -1)
            return dp[row][col];

        if (row == mat.length - 1) {
            return mat[row][col];
        }

        int bottom = mat[row][col] + dpSolution(mat, row + 1, col, dp);
        int bottomRight = mat[row][col] + dpSolution(mat, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(bottom, bottomRight);
    }

    private static int tabulation(int[][] mat) {
        int m = mat.length;
        int n = mat[m - 1].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = mat[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = mat[i].length - 1; j >= 0; j--) {

                int down = dp[i + 1][j];
                int downRight = (j < n - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE / 2;

                dp[i][j] = mat[i][j] + Math.min(down, downRight);
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

        int[] nextRow = mat[m - 1].clone();

        for (int i = m - 2; i >= 0; i--) {

            int[] currentRow = new int[mat[i].length];

            for (int j = 0; j < mat[i].length; j++) {

                int down = nextRow[j];
                int diagonal = nextRow[j + 1];

                currentRow[j] = mat[i][j] + Math.min(down, diagonal);
            }

            nextRow = currentRow;
        }

        return nextRow[0];
    }
}