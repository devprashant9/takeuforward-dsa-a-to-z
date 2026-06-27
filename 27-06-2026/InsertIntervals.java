import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * InsertIntervals
 */
public class InsertIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 },
                { 6, 9 }
        };

        int[] newInterval = { 2, 5 };

        int[][] ans = mergeNewInterval(intervals, newInterval);

        for (int[] r : ans) {
            System.out.println(Arrays.toString(r));
        }
    }

    private static int[][] mergeNewInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}