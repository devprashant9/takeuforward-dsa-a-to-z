import java.util.Arrays;

public class LongestSubarraySumPostivies {

    public static int longestSubarraySumPositives(int[] nums, int K) {
        int max = 0;
        int prefixSum = 0;

        int i = 0, j = 0;
        while (j < nums.length) {
            prefixSum += nums[j];

            if (prefixSum == K) {
                max = Math.max(max, j - i + 1);
            }

            while (prefixSum > K) {
                prefixSum -= nums[i];
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int K = 15;
        System.out.println("Longest Subarray Sum Positives is: " + Arrays.toString(nums));
        System.out.println(longestSubarraySumPositives(nums, K));
    }
}