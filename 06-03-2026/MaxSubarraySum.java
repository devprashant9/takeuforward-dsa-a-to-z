class MaxSubarraySum {

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = Math.max(maxSum, sum);
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}