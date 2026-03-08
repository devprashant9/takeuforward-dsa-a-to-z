import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenSum {

    public static int countSubarrayWithGivenSum(int[] nums, int K) {
        int count = 0;
        int prefixSum = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum - K;
            count += mp.getOrDefault(rem, 0);
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        int K = 6;
        System.out.println("Subarray With Given Sum Count is: " + countSubarrayWithGivenSum(nums, K));
    }
}