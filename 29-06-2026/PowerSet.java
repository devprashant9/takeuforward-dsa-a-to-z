import java.util.ArrayList;
import java.util.List;

/**
 * PowerSet
 */
public class PowerSet {

    public static void main(String[] args) {
        int[] n = { 1, 2, 3 };
        System.out.println(powerSet(n));
    }

    private static List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        int totalSubsets = 1 << n;
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}