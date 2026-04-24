import java.util.ArrayList;
import java.util.List;

public class GenerateSubsetArray {

    public static List<List<Integer>> generateSubsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> store) {
        if (i == nums.length) {
            store.add(new ArrayList<>(ans));
            return store;
        }

        int num = nums[i];
        ans.add(num);
        generateSubsets(nums, i + 1, ans, store);
        ans.remove(ans.size() - 1);
        generateSubsets(nums, i + 1, ans, store);

        return store;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> store = new ArrayList<>();
        List<List<Integer>> ans = generateSubsets(nums, 0, new ArrayList<>(), store);

        System.out.println(ans);
    }
}