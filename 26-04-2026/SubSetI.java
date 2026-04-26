import java.util.ArrayList;
import java.util.List;

public class SubSetI {

    public static List<Integer> subsetSum(int[] nums, int i, int sum, List<Integer> store) {
        if (i == nums.length) {
            store.add(sum);
            return store;
        }

        subsetSum(nums, i + 1, sum + nums[i], store);
        subsetSum(nums, i + 1, sum, store);

        return store;
    }

    public static void main(String[] args) {
        System.out.println(subsetSum(new int[] { 5, 2, 1 }, 0, 0, new ArrayList<>()));
    }
}