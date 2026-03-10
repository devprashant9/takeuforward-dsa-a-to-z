import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubarrayGivenXOR_K {

    public static int countSubarray(int[] nums, int K) {
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        int sumXor = 0;
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sumXor ^= nums[i];
            int rem = sumXor ^ K;
            cnt += mp.getOrDefault(rem, 0);
            mp.put(sumXor, mp.getOrDefault(sumXor, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 6, 4 };
        int K = 6;
        System.out.println("Number of Sum XOR K in Array is: " + Arrays.toString(nums));
        System.out.println(countSubarray(nums, K));
    }
}