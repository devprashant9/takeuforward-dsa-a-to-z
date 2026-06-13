import java.util.Arrays;

public class MinimumCoins {

    public static int minimumCoins(int[] coins, int amount) {
        int ans = recursive(coins, 0, amount);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        int ans2 = dpSolution(coins, 0, amount, dp);
        System.out.println(ans2 == Integer.MAX_VALUE ? -1 : ans2);
        return tabulation(coins, amount);
    }

    private static int recursive(int[] nums, int i, int target) {
        if (target == 0)
            return 0;
        if (i == nums.length)
            return Integer.MAX_VALUE;

        int notTake = recursive(nums, i + 1, target);
        int take = Integer.MAX_VALUE;
        if (nums[i] <= target) {
            int res = recursive(nums, i, target - nums[i]);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        return Math.min(take, notTake);
    }

    private static int dpSolution(int[] nums, int i, int target, int[][] dp) {
        if (target == 0)
            return 0;
        if (dp[i][target] != -1)
            return dp[i][target];
        if (i == nums.length)
            return Integer.MAX_VALUE;

        int notTake = dpSolution(nums, i + 1, target, dp);
        int take = Integer.MAX_VALUE;
        if (nums[i] <= target) {
            int res = dpSolution(nums, i, target - nums[i], dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[i][target] = Math.min(take, notTake);
    }

    private static int tabulation(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int t = 1; t <= target; t++) {
            dp[n][t] = Integer.MAX_VALUE;
        }

        for (int i = n; i >= 0; i--) {
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int t = 1; t <= target; t++) {

                int notTake = dp[i + 1][t];

                int take = Integer.MAX_VALUE;
                if (nums[i] <= t) {
                    int res = dp[i][t - nums[i]];

                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }

                dp[i][t] = Math.min(take, notTake);
            }
        }

        int ans = dp[0][target];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}