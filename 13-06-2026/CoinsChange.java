public class CoinsChange {

    public int count(int[] coins, int N, int amount) {
        int MOD = (int) 1e9 + 7;
        return recursive(coins, 0, amount) % MOD;
    }

    private static int recursive(int[] nums, int i, int target) {
        if (target == 0)
            return 1;
        if (i == nums.length)
            return 0;

        int notTake = recursive(nums, i + 1, target);
        int take = 0;
        if (nums[i] <= target)
            take = recursive(nums, i, target - nums[i]);

        return take + notTake;
    }
}