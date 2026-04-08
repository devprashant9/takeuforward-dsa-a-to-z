import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static int fruitsInBasket(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int maxFruits = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.size() > 2) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }

            maxFruits = Math.max(maxFruits, j - i + 1);
            j++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 2 };
        System.out.println("Maximum Fruits in Basket is: " + fruitsInBasket(nums));
    }
}