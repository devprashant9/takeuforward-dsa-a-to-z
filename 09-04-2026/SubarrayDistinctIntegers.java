import java.util.HashMap;
import java.util.Map;

public class SubarrayDistinctIntegers {

    public static int subarrayDistinctIntegers(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static int atMost(int[] nums, int goal) {
        int i = 0, j = 0;
        int n = nums.length;
        int cnt = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.size() > goal) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }

            cnt += (j - i + 1);
            j++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println("Subarrays With K Distinct Integers Are: " + subarrayDistinctIntegers(nums, k));
    }
}