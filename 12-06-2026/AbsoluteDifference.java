public class AbsoluteDifference {

    public int minDifference(int[] arr, int n) {
        int totalSum = sum(arr);
        int target = totalSum / 2;

        int subSetSum1 = recursive(arr, 0, target);
        int subSetSum2 = totalSum - subSetSum1;

        return Math.abs(subSetSum1 - subSetSum2);
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }

    private static int recursive(int[] nums, int i, int target) {
        if (i == nums.length)
            return 0;

        int notTake = recursive(nums, i + 1, target);

        int take = 0;
        if (nums[i] <= target) {
            take = nums[i] + recursive(nums, i + 1, target - nums[i]);
        }

        return Math.max(take, notTake);
    }
}