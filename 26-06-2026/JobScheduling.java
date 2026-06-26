import java.util.Arrays;

public class JobScheduling {

    public static void main(String[] args) {
        int[][] jobs = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };
        System.out.println(Arrays.toString(jobScheduling(jobs)));
    }

    public static int[] jobScheduling(int[][] jobs) {

        int n = jobs.length;

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        int maxDeadline = maxDeadline(jobs);

        // Time slots from 1 to maxDeadline
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int countJobs = 0;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {

            int id = jobs[i][0];
            int deadline = jobs[i][1];
            int profit = jobs[i][2];

            // Find the latest available slot on or before the deadline
            for (int j = deadline; j >= 1; j--) {

                if (slot[j] == -1) {
                    slot[j] = id;
                    countJobs++;
                    maxProfit += profit;
                    break;
                }
            }
        }

        return new int[] { countJobs, maxProfit };
    }

    private static int maxDeadline(int[][] jobs) {
        int max = 0;

        for (int[] job : jobs) {
            max = Math.max(max, job[1]);
        }

        return max;
    }
}