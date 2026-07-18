import java.util.Arrays;

public class MinCostToCutSticks {

    public static void main(String[] args) {

        int[] cuts = { 1, 3, 4, 5 };
        int stickLength = 7;

        int[] arr = transformArray(cuts, stickLength);

        int m = cuts.length;

        System.out.println(minCost(arr, 1, m));

        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(minCostMemoization(arr, 1, m, dp));
    }

    private static int[] transformArray(int[] cuts, int stickLength) {

        int n = cuts.length;

        int[] arr = new int[n + 2];

        arr[0] = 0;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = cuts[i];
        }

        arr[n + 1] = stickLength;

        return arr;
    }

    private static int minCost(int[] arr, int i, int j) {

        if (i > j)
            return 0;

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = (arr[j + 1] - arr[i - 1])
                    + minCost(arr, i, k - 1)
                    + minCost(arr, k + 1, j);

            minimum = Math.min(minimum, cost);
        }

        return minimum;
    }

    private static int minCostMemoization(int[] arr, int i, int j, int[][] dp) {

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = (arr[j + 1] - arr[i - 1])
                    + minCostMemoization(arr, i, k - 1, dp)
                    + minCostMemoization(arr, k + 1, j, dp);

            minimum = Math.min(minimum, cost);
        }

        return dp[i][j] = minimum;
    }
}