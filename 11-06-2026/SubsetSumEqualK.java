import java.util.Arrays;

public class SubsetSumEqualK {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 7, 3 };
        int K = 6;

        System.out.println(recursive(nums, 0, K));

        int n = nums.length;
        int[][] dp = new int[n + 1][K + 1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(dpSolution(nums, 0, K, dp));

        System.out.println(tabulation(nums, n));

        System.out.println(spaceOptimization(nums, n));
    }

    private static boolean recursive(int[] nums, int i, int target) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (i == nums.length)
            return false;

        boolean take = recursive(nums, i + 1, target - nums[i]);
        boolean notTake = recursive(nums, i + 1, target);

        return take || notTake;
    }

    private static boolean dpSolution(int[] nums, int i, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        if (i == nums.length)
            return false;

        boolean take = dpSolution(nums, i + 1, target - nums[i], dp);
        boolean notTake = dpSolution(nums, i + 1, target, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;

        return dp[i][target] == 1;
    }

    private static boolean tabulation(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int t = target; t >= 0; t--) {

                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[i + 1][t - nums[i]];
                }

                boolean notTake = dp[i + 1][t];

                dp[i][target] = take || notTake;
            }
        }

        return dp[0][target];
    }

    private static boolean spaceOptimization(int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int t = target; t >= 0; t--) {

                boolean notTake = dp[t];

                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[t - nums[i]];
                }

                dp[t] = take || notTake;
            }
        }

        return dp[0];
    }
}