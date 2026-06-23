import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleSubset {

    public static void main(String[] args) {
        int[] nums = { 16, 8, 2, 4, 32 };
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        solve(nums, 0, -1, new ArrayList<>(), result);

        return result;
    }

    private static void solve(int[] nums, int i, int prev, List<Integer> current, List<Integer> result) {
        if (i == nums.length) {
            if (current.size() > result.size()) {
                result.clear();
                result.addAll(current);
            }
            return;
        }

        // Not take
        solve(nums, i + 1, prev, current, result);

        // Take
        if (prev == -1 || nums[i] % nums[prev] == 0) {
            current.add(nums[i]);

            solve(nums, i + 1, i, current, result);

            current.remove(current.size() - 1); // backtrack
        }
    }
}