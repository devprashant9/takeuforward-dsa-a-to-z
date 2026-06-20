import java.util.Arrays;

public class BuyAndSellStockII {
    public static void main(String[] args) {
        int[] arr = { 9, 2, 6, 4, 7, 3 };
        System.out.println(recursive(arr, 0, 0));

        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        System.out.println(memoization(arr, 0, 0, dp));

        System.out.println(tabulation(arr, n));
        System.out.println(spaceOptimization(arr, n));
    }

    private static int recursive(int[] arr, int i, int status) {
        if (i == arr.length)
            return 0;

        int profit = 0;
        if (status == 0) {
            profit = Math.max((-1) * arr[i] + recursive(arr, i + 1, 1), recursive(arr, i + 1, 0));
        } else {
            profit = Math.max(arr[i] + recursive(arr, i + 1, 0), recursive(arr, i + 1, 1));
        }

        return profit;
    }

    private static int memoization(int[] arr, int i, int status, int[][] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i][status] != -1)
            return dp[i][status];

        int profit = 0;
        if (status == 0) {
            profit = Math.max((-1) * arr[i] + memoization(arr, i + 1, status + 1, dp),
                    memoization(arr, i + 1, status, dp));
        } else {
            profit = Math.max(arr[i] + memoization(arr, i + 1, status - 1, dp), memoization(arr, i + 1, status, dp));
        }

        return dp[i][status] = profit;
    }

    private static int tabulation(int[] arr, int n) {
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max((-1) * arr[i] + dp[i + 1][j + 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.max(arr[i] + dp[i + 1][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    private static int spaceOptimization(int[] arr, int n) {
        int[] dp = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    curr[0] = Math.max((-1) * arr[i] + dp[1], dp[0]);
                } else {
                    curr[1] = Math.max(arr[i] + dp[0], dp[1]);
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}
