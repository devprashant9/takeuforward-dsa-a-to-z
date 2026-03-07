import java.util.HashMap;
import java.util.Map;

class CountSubarrayWithGivenSum {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int sum = 0;

        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;

            count += mp.getOrDefault(rem, 0);

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}