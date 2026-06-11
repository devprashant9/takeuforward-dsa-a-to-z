import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = { 1, 10, 21, 10 };

        int totalSum = sumArray(nums);
        if ((totalSum & 1) == 1) {
            System.out.println(false);
        }

        int target = totalSum / 2;
        System.out.println(recursive(nums, 0, target));

        int[][] dp = new int[nums.length + 1][target + 1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(memoization(nums, 0, target, dp));

        System.out.println(tabulation(nums, target));

        System.out.println(spaceOptimization(nums, target));
    }

    private static int sumArray(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }

    private static boolean recursive(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (i == nums.length) {
            return false;
        }

        boolean take = recursive(nums, i + 1, target - nums[i]);
        boolean notTake = recursive(nums, i + 1, target);

        return take || notTake;
    }

    private static boolean memoization(int[] nums, int i, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        if (target < 0) {
            return false;
        }
        if (i == nums.length) {
            return false;
        }

        boolean take = recursive(nums, i + 1, target - nums[i]);
        boolean notTake = recursive(nums, i + 1, target);

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
            for (int j = target; j >= 0; j--) {
                boolean notTake = dp[i + 1][j];

                boolean take = false;
                if (j >= nums[i]) {
                    take = dp[i + 1][j - nums[i]];
                }

                dp[i][j] = take || notTake;
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