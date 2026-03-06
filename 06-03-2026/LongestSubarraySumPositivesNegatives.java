import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumPositivesNegatives {

    public static int maximumSubarraySum(int[] nums, int K) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == K) {
                maxLength = Math.max(maxLength, i + 1);
            }

            int target = sum - K;
            if (mp.containsKey(target)) {
                int length = i - mp.get(target);
                maxLength = Math.max(maxLength, length);
            }

            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { -10, -5, 10, 5, 0, 0, 20, -15 };
        int K = 25;
        System.out.println("Maximum Length of Subarray Sum is: ");
        System.out.println(maximumSubarraySum(nums, K));

    }
}