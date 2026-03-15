import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySumZero {

    public static int subarraySumZero(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max = -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                max = Math.max(max, i + 1);
            } else if (mp.containsKey(sum)) {
                int len = mp.get(sum);
                max = Math.max(max, i - len);
            } else {
                mp.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Largest Subarray With 0 Sum is: " + Arrays.toString(nums));
        System.out.println(subarraySumZero(nums));
    }
}