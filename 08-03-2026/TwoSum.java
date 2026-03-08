import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int K) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = K - nums[i];
            if (mp.containsKey(rem)) {
                return new int[] { mp.get(rem), i };
            }
            mp.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 8, 1 };
        int K = 7;
        System.out.println("Position of Numbers Equal to Summation K is: " + Arrays.toString(twoSum(nums, K)));

    }
}