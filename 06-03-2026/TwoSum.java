import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int K) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = K - nums[i];

            if (mp.containsKey(target)) {
                return new int[] { mp.get(target), i };
            }
            mp.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 6, 2, 10, 3 };
        int K = 7;
        System.out.println("Array Indices For Given Sum Are: ");
        System.out.println(Arrays.toString(twoSum(nums, K)));

    }
}