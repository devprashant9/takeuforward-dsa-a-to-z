import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int n = nums.length;

        System.out.println(mcm(nums, 1, n - 1));

        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(mcmMemoization(nums, 1, n - 1, dp));
    }

    private static int mcm(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }

        int minimum = (int) (1e9 + 7);
        for (int k = i; k <= j - 1; k++) {
            int operations = arr[i - 1] * arr[k] * arr[j] + mcm(arr, i, k) + mcm(arr, k + 1, j);
            minimum = Math.min(minimum, operations);
        }

        return minimum;
    }

    private static int mcmMemoization(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minimum = (int) (1e9 + 7);
        for (int k = i; k <= j - 1; k++) {
            int operations = arr[i - 1] * arr[k] * arr[j] + mcmMemoization(arr, i, k, dp)
                    + mcmMemoization(arr, k + 1, j, dp);
            minimum = Math.min(minimum, operations);
        }

        return dp[i][j] = minimum;
    }
}