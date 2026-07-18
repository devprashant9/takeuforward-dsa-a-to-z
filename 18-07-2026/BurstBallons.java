import java.util.Arrays;

public class BurstBallons {

    public static void main(String[] args) {

        int[] balloons = { 3, 1, 5, 8 };

        int[] arr = transformArray(balloons);

        int n = balloons.length;

        System.out.println(maxCoins(arr, 1, n));

        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(maxCoinsMemoization(arr, 1, n, dp));
    }

    private static int[] transformArray(int[] balloons) {

        int n = balloons.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;

        for (int i = 0; i < n; i++)
            arr[i + 1] = balloons[i];

        arr[n + 1] = 1;

        return arr;
    }

    private static int maxCoins(int[] arr, int i, int j) {

        if (i > j)
            return 0;

        int maximum = 0;

        for (int k = i; k <= j; k++) {

            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                    + maxCoins(arr, i, k - 1)
                    + maxCoins(arr, k + 1, j);

            maximum = Math.max(maximum, coins);
        }

        return maximum;
    }

    private static int maxCoinsMemoization(int[] arr, int i, int j, int[][] dp) {

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int maximum = 0;

        for (int k = i; k <= j; k++) {

            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                    + maxCoinsMemoization(arr, i, k - 1, dp)
                    + maxCoinsMemoization(arr, k + 1, j, dp);

            maximum = Math.max(maximum, coins);
        }

        return dp[i][j] = maximum;
    }
}