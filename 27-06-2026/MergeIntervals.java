import java.util.ArrayList;
import java.util.List;

/**
 * MergeIntervals
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };

        System.out.println(mergeOverlappingIntervals(intervals));
    }

    private static List<List<Integer>> mergeOverlappingIntervals(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty())
                ans.add(new ArrayList<>(List.of(interval[0], interval[1])));

            if (!ans.isEmpty() && interval[0] <= ans.get(ans.size() - 1).get(1)) {
                ans.get(ans.size() - 1).set(1, interval[1]);
            } else {
                ans.add(new ArrayList<>(List.of(interval[0], interval[1])));
            }
        }
        return ans;
    }
}