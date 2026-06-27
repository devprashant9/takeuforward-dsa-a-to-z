import java.util.Arrays;

/**
 * CountMinIntervalsRemoval
 */
public class CountMinIntervalsRemoval {

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3 },
                { 1, 4 },
                { 3, 5 },
                { 3, 4 },
                { 4, 5 }
        };

        System.out.println(minIntervalCount(intervals));
    }

    private static int minIntervalCount(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int cnt = 1; // all valid intervals
        int previousEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];

            if (curr_start >= previousEnd) {
                cnt++;
                previousEnd = curr_end;
            }
        }
        return n - cnt; // all - valid = invalid
    }
}