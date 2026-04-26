import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {

    public static void subsetSumDuplicates(int[] nums, int i, List<Integer> ans) {
        System.out.println(ans);

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            ans.add(nums[j]);
            subsetSumDuplicates(nums, j + 1, ans);
            ans.remove(ans.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        Arrays.sort(nums);
        subsetSumDuplicates(nums, 0, new ArrayList<>());
    }
}