import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithSumZero {

    public static int largestSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                max = Math.max(max, i + 1);
            } else if (mp.containsKey(sum)) {
                max = Math.max(max, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Largest Subarray Length With Sum With 0 is: " + Arrays.toString(nums));
        System.out.println(largestSubarray(nums));
    }
}