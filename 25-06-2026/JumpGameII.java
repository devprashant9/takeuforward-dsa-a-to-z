import java.util.Arrays;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(recursive(nums, 0));

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(memoized(nums, 0, dp));

        System.out.println(greedy(nums));
    }

    private static int recursive(int[] nums, int i) {
        if (i >= nums.length)
            return Integer.MAX_VALUE / 2;
        if (i == nums.length - 1)
            return 0;
        if (nums[i] == 0)
            return Integer.MAX_VALUE / 2;

        int minSteps = Integer.MAX_VALUE / 2;
        for (int j = 1; j <= nums[i]; j++) {
            minSteps = Math.min(minSteps, 1 + recursive(nums, i + j));
        }

        return minSteps;
    }

    private static int memoized(int[] nums, int i, int[] dp) {
        if (i >= nums.length)
            return Integer.MAX_VALUE / 2;
        if (dp[i] != -1)
            return dp[i];
        if (i == nums.length - 1)
            return 0;
        if (nums[i] == 0)
            return Integer.MAX_VALUE / 2;

        int minSteps = Integer.MAX_VALUE / 2;
        for (int j = 1; j <= nums[i]; j++) {
            minSteps = Math.min(minSteps, 1 + memoized(nums, i + j, dp));
        }

        return dp[i] = minSteps;
    }

    private static int greedy(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = 0;
        int minJumps = 0;
        for (int i = 0; i < n - 1; i++) {
            right = Math.max(right, nums[i] + i);
            if (i == left) {
                minJumps++;
                left = right;
            }
        }
        return minJumps;
    }
}