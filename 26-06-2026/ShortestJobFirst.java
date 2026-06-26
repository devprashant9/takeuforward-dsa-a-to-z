import java.util.Arrays;

/**
 * ShortestJobFirst
 */
public class ShortestJobFirst {

    public static void main(String[] args) {
        int[] bt = { 4, 1, 3, 7, 2 };
        System.out.println(sjfAlgorithm(bt));
    }

    public static long sjfAlgorithm(int[] bt) {

        Arrays.sort(bt);

        int n = bt.length;

        int currentTime = 0;
        long totalWaitingTime = 0;

        for (int i = 0; i < n; i++) {
            int start = currentTime;
            int end = start + bt[i];

            totalWaitingTime += start;
            currentTime = end;
        }

        return totalWaitingTime / n;
    }
}