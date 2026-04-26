import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumWithDuplicates {

    public static void printCombinationSum(int[] nums, int start, int k, int sum, List<Integer> ans) {

        if (sum == k) {
            System.out.println(ans);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (sum + nums[i] > k) {
                break;
            }

            ans.add(nums[i]);
            printCombinationSum(nums, i + 1, k, sum + nums[i], ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2, 7, 6, 1, 5 };
        Arrays.sort(nums);
        printCombinationSum(nums, 0, 8, 0, new ArrayList<>());
    }
}