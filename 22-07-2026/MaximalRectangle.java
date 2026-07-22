
public class MaximalRectangle {

    public static int maximalRectangle(int[][] grid, int m, int n) {
        int[][] dp = new int[m][n];
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (dp[k][j] == 0) {
                            width = Math.min(width, dp[k][j]);
                            maxArea = Math.max(maxArea, width * (i - k + 1));
                        }
                    }
                }
            }
        }
        return maxArea;
    }
}