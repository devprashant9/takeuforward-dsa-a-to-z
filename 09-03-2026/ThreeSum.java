import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums, int K) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == K) {
                    list.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                    while (nums[k] == nums[k + 1] && k > j) {
                        k--;
                    }
                } else if (sum < K) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -2, 0, 3, -3, 5 };
        int K = 0;
        Arrays.sort(nums);
        System.out.println("Triplets For Three Sum Are: " + threeSum(nums, K));
    }
}