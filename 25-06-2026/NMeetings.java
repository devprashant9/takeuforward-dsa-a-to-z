import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetings {

    private record Pair<K, V>(K first, V second) {
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        System.out.println(nMeetings(start, end));
    }

    private static int nMeetings(int[] start, int[] end) {
        int n = start.length;

        List<Pair<Integer, Integer>> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            intervals.add(new Pair<>(start[i], end[i]));
        }

        Collections.sort(intervals, (a, b) -> (a.second() - b.second()));

        int totalMeetings = 1;
        int previousEnd = intervals.get(0).second();
        for (int i = 1; i < n; i++) {
            Pair<Integer, Integer> pair = intervals.get(i);
            if (pair.first() > previousEnd) {
                totalMeetings++;
                previousEnd = pair.second();
            }
        }
        return totalMeetings;
    }
}