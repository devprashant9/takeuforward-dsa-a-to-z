import java.util.Arrays;

public class BuyAndSellStockIII {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 11, 5 };
        int n = arr.length;

        System.out.println(recursive(arr, 0, 0, 2));

        int[][][] dp = new int[n + 1][2][3];
        for (int[][] r : dp) {
            for (int[] r1 : r)
                Arrays.fill(r1, -1);
        }
        System.out.println(memoization(arr, 0, 0, 2, dp));

        System.out.println(tabulation(arr, n));
    }

    private static int recursive(int[] arr, int i, int status, int maxCap) {
        if (maxCap == 0)
            return 0;
        if (i == arr.length)
            return 0;

        int profit = 0;
        if (status == 0) {
            profit = Math.max((-1) * arr[i] + recursive(arr, i + 1, status + 1, maxCap),
                    recursive(arr, i + 1, status, maxCap));
        } else {
            profit = Math.max(arr[i] + recursive(arr, i + 1, status - 1, maxCap - 1),
                    recursive(arr, i + 1, status, maxCap));
        }
        return profit;
    }

    private static int memoization(int[] arr, int i, int status, int maxCap, int[][][] dp) {
        if (maxCap == 0)
            return 0;
        if (dp[i][status][maxCap] != -1)
            return dp[i][status][maxCap];
        if (i == arr.length)
            return 0;

        int profit = 0;
        if (status == 0) {
            profit = Math.max((-1) * arr[i] + memoization(arr, i + 1, status + 1, maxCap, dp),
                    memoization(arr, i + 1, status, maxCap, dp));
        } else {
            profit = Math.max(arr[i] + memoization(arr, i + 1, status - 1, maxCap - 1, dp),
                    memoization(arr, i + 1, status, maxCap, dp));
        }
        return dp[i][status][maxCap] = profit;
    }

    private static int tabulation(int[] arr, int n) {
        int[][][] dp = new int[n + 1][2][3];

        // Base Case
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j][0] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 0) {
                        dp[i][j][k] = Math.max((-1) * arr[i] + dp[i + 1][j + 1][k], dp[i + 1][j][k]);
                    } else {
                        dp[i][j][k] = Math.max(arr[i] + dp[i + 1][j - 1][k - 1], dp[i + 1][j][k]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}