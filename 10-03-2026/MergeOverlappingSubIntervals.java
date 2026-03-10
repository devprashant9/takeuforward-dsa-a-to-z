import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {

    public static List<List<Integer>> mergeIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i][0];
            int end = nums[i][1];
            if (list.isEmpty() || start > list.get(list.size() - 1).get(1)) {
                list.add(new ArrayList<>(Arrays.asList(start, end)));
            } else {
                List<Integer> prev = list.get(list.size() - 1);
                prev.set(1, Math.max(end, prev.get(1)));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 5 },
                { 3, 6 },
                { 8, 10 },
                { 15, 18 }
        };
        System.out.println("Merged Intervals Are: ");
        System.out.println(mergeIntervals(nums));
    }
}