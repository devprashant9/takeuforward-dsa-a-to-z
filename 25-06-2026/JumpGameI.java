import java.util.Arrays;

public class JumpGameI {

    public static void main(String[] args) {

        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(recursive(nums, 0));

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(memoized(nums, 0, dp));

        System.out.println(greedy(nums));
    }

    private static boolean recursive(int[] nums, int i) {
        if (i >= nums.length)
            return false;

        if (i == nums.length - 1)
            return true;

        if (nums[i] == 0)
            return false;

        for (int j = 1; j <= nums[i]; j++) {
            if (recursive(nums, i + j))
                return true;
        }

        return false;
    }

    private static boolean memoized(int[] nums, int i, int[] dp) {
        if (i >= nums.length)
            return false;

        if (dp[i] != -1)
            return dp[i] == 1;

        if (i == nums.length - 1) {
            dp[i] = 1;
            return true;
        }

        if (nums[i] == 0) {
            dp[i] = 0;
            return false;
        }

        for (int j = 1; j <= nums[i]; j++) {
            if (memoized(nums, i + j, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }

    private static boolean greedy(int[] nums) {
        int n = nums.length;

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= n)
                return true;
        }

        return true;
    }
}