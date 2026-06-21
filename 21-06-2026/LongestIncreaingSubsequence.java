import java.util.Arrays;

public class LongestIncreaingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println(recursive(arr, 0, -1));

        int[][] dp = new int[n][n + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        System.out.println(memoization(arr, 0, -1, dp));

        System.out.println(tabulation(arr));
        System.out.println(spaceOptimization(arr));
        System.out.println();
    }

    private static int recursive(int[] arr, int i, int prev) {
        if (i == arr.length)
            return 0;

        int notTake = recursive(arr, i + 1, prev);

        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + recursive(arr, i + 1, i);
        }

        return Math.max(notTake, take);
    }

    private static int memoization(int[] arr, int i, int prev, int[][] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        int notTake = memoization(arr, i + 1, prev, dp);

        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + memoization(arr, i + 1, i, dp);
        }

        return dp[i][prev + 1] = Math.max(notTake, take);
    }

    private static int tabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int notTake = dp[i + 1][j + 1];

                int take = 0;
                if (j == -1 || arr[i] > arr[j]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][j + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }

    private static int spaceOptimization(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int notTake = dp[i + 1];

                int take = 0;
                if (j == -1 || arr[i] > arr[j]) {
                    take = 1 + dp[i + 1];
                }

                dp[j + 1] = Math.max(notTake, take);
            }
        }
        return dp[0];
    }
}