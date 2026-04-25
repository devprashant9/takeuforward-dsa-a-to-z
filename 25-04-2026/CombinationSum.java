import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void printCombinationSum(int[] nums, int i, int k, int sum, List<Integer> ans) {

        if (sum == k) {
            System.out.println(ans);
            return;
        }

        if (i == nums.length || sum > k) {
            return;
        }

        if (sum <= k) {
            sum += nums[i];
            ans.add(nums[i]);
            printCombinationSum(nums, i, k, sum, ans);

            int size = ans.size();
            if (size > 0) {
                sum -= ans.get(size - 1);
                ans.remove(size - 1);
            }
        }
        printCombinationSum(nums, i + 1, k, sum, ans);
    }

    public static void main(String[] args) {
        printCombinationSum(new int[] { 2, 3, 5, 4 }, 0, 7, 0, new ArrayList<>());
    }
}