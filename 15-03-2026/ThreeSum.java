import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = nums.length - 1;
            for (int j = i + 1; j < k; j++) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -1, -1, 3, -1 };
        System.out.println("Three Sum Triplets in Array is: " + Arrays.toString(nums));
        System.out.println(threeSum(nums));
    }
}