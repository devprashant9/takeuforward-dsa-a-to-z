
public class SubsquareMatrices {

    public static int getTotalSquares(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        return sum(dp);
    }

    private static int sum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }
}