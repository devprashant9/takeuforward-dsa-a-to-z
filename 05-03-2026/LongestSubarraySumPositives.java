import java.util.Arrays;

public class LongestSubarraySumPositives {

    public static int longestSubArraySumWithGivenK(int[] nums, int K) {
        int i = 0, j = 0, max = 0;
        int sum = nums[0];
        while (j < nums.length) {
            while (i <= j && sum > K) {
                sum -= nums[i];
                i++;
            }

            if (sum == K) {
                max = Math.max(max, j - 1 + 1);
            }

            j++;
            if (j < nums.length) {
                sum += nums[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int K = 15;
        System.out.println("Longest Subarray With Given Sum " + K + " is: " + Arrays.toString(nums));
        System.out.println(longestSubArraySumWithGivenK(nums, 0));
    }
}