import java.util.Arrays;

public class CountSubsetSumK {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 1 };
        int K = 5;
        Arrays.toString(perfectSum(arr, K));
    }

    public static int[] perfectSum(int[] arr, int K) {
        int MOD = (int) 1e9 + 7;

        int ans = recursive(arr, 0, K) % MOD;

        int[][] dp = new int[arr.length + 1][K + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);

        return new int[] { dpSolution(arr, 0, K, dp) % MOD, dpSolution(arr, 0, K, dp) % MOD,
                tabulationOptimized(arr, K) % MOD, tabulation(arr, ans) };
    }

    private static int recursive(int[] nums, int i, int target) {
        if (target == 0)
            return 1;
        if (i == nums.length)
            return 0;
        if (target < 0)
            return 0;

        int notTake = recursive(nums, i + 1, target);
        int take = recursive(nums, i + 1, target - nums[i]);

        return take + notTake;
    }

    private static int dpSolution(int[] nums, int i, int target, int[][] dp) {
        if (target == 0)
            return 1;
        if (dp[i][target] != -1)
            return dp[i][target];
        if (i == nums.length)
            return 0;
        if (target < 0)
            return 0;

        int notTake = recursive(nums, i + 1, target);
        int take = recursive(nums, i + 1, target - nums[i]);

        return dp[i][target] = take + notTake;
    }

    private static int tabulation(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target; j >= 0; j--) {
                int notTake = dp[i + 1][j];

                int take = 0;
                if (j >= nums[i]) {
                    take = dp[i + 1][j - nums[i]];
                }

                dp[i][j] = take + notTake;
            }
        }
        return dp[0][target];
    }

    private static int tabulationOptimized(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target; j >= 0; j--) {
                int notTake = dp[j];

                int take = 0;
                if (j >= nums[i]) {
                    take = dp[j - nums[i]];
                }

                dp[j] = take + notTake;
            }
        }
        return dp[target];
    }
}