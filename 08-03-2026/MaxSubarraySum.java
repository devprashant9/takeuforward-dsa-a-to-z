import java.util.Arrays;

public class MaxSubarraySum {

    public static int maximumSum(int[] nums) {
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = Math.max(maxSum, currentSum);
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, -2, 7, -4 };
        System.out.println("Maximum Subarray Sum is: " + Arrays.toString(nums));
        System.out.println(maximumSum(nums));
    }
}