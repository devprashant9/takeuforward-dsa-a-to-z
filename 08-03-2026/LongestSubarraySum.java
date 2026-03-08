import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySum {

    public static int longestSubarraySum(int[] nums, int K) {
        int max = 0;
        int prefixSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == K) {
                max = Math.max(max, i + 1);
            }

            int rem = prefixSum - K;
            if (mp.containsKey(rem)) {
                int length = i - mp.get(rem);
                max = Math.max(max, length);
            }

            if (!mp.containsKey(prefixSum)) {
                mp.put(prefixSum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int K = 15;
        System.out.println("Longest Subarray Sum is: " + Arrays.toString(nums));
        System.out.println(longestSubarraySum(nums, K));
    }
}