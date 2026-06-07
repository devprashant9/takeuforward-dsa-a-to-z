import java.util.Arrays;

public class HouseRobberI {

    private static int recursive(int[] nums, int i) {
        int n = nums.length;
        if (i >= n)
            return 0;
        if (i == (n - 1))
            return nums[i];

        int takeCurr = nums[i] + recursive(nums, i + 2);
        int notTakeCurr = recursive(nums, i + 1);

        return Math.max(takeCurr, notTakeCurr);
    }

    private static int dpSolution(int[] nums, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int n = nums.length;
        if (i >= n)
            return 0;
        if (i == (n - 1))
            return nums[i];

        int takeCurr = nums[i] + dpSolution(nums, i + 2, dp);
        int notTakeCurr = dpSolution(nums, i + 1, dp);

        return dp[i] = Math.max(takeCurr, notTakeCurr);
    }

    private static int tabulation(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            int take = nums[i] + dp[i + 2];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    private static int tabulationOptimized(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int prev = 0;

        for (int i = n - 1; i >= 0; i--) {
            int take = nums[i] + curr;
            int skip = prev;

            int ans = Math.max(take, skip);
            curr = prev;
            prev = ans;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 9 };

        System.out.println(recursive(nums, 0));

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(dpSolution(nums, 0, dp));

        System.out.println(tabulation(nums));
        System.out.println(tabulationOptimized(nums));
    }
}