class PrintMaxSubarraySum {
    public static int[] maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = -1;
        int ansEnd = -1;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = Math.max(maxSum, sum);
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[] { ansStart, ansEnd };
    }
}