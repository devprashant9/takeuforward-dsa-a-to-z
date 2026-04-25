public class ExistsSubSequenceSumK {

    public static boolean countSubsequenceWithTargetSum(int[] nums, int k) {
        return helper(nums, 0, k, 0);
    }

    public static boolean helper(int[] nums, int i, int k, int sum) {
        if (i == nums.length) {
            if (sum == k) {
                return true;
            }
            return false;
        }
        return helper(nums, i + 1, k, sum + nums[i]) || helper(nums, i + 1, k, sum);
    }

    public static void main(String[] args) {
        System.out.println(countSubsequenceWithTargetSum(new int[] { 4, 9, 2, 5, 1 }, 10));
    }
}