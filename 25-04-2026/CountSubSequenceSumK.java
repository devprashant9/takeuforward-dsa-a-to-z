public class CountSubSequenceSumK {

    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        return helper(nums, 0, k, 0);
    }

    public static int helper(int[] nums, int i, int k, int sum) {
        if (i == nums.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        return helper(nums, i + 1, k, sum + nums[i]) + helper(nums, i + 1, k, sum);
    }

    public static void main(String[] args) {
        System.out.println(countSubsequenceWithTargetSum(new int[] { 4, 9, 2, 5, 1 }, 10));
    }
}