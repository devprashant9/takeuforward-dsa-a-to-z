import java.util.Arrays;

public class NinjasTraining {
    
    public static void main(String[] args) {
        int[][] days = {
                { 10, 40, 70 },
                { 10, 80, 100 },
                { 70, 90, 30 }
        };

        System.out.println(recursive(days, 0, -1));

        int[][] dp = new int[days.length][4];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(dpSolution(days, 0, 3, dp));

        System.out.println(tabulation(days));
        System.out.println(tabulationOptimized(days));
    }

    private static int recursive(int[][] days, int i, int last) {
        if (i >= days.length)
            return 0;

        int chooseA = Integer.MIN_VALUE;
        int chooseB = Integer.MIN_VALUE;
        int chooseC = Integer.MIN_VALUE;

        if (last != 0)
            chooseA = days[i][0] + recursive(days, i + 1, 0);

        if (last != 1)
            chooseB = days[i][1] + recursive(days, i + 1, 1);

        if (last != 2)
            chooseC = days[i][2] + recursive(days, i + 1, 2);

        return Math.max(chooseA, Math.max(chooseB, chooseC));
    }

    private static int dpSolution(int[][] days, int i, int last, int[][] dp) {
        if (i >= days.length)
            return 0;

        if (dp[i][last] != -1)
            return dp[i][last];

        int chooseFirst = Integer.MIN_VALUE;
        int chooseSecond = Integer.MIN_VALUE;
        int chooseThird = Integer.MIN_VALUE;

        if (last != 0) {
            chooseFirst = days[i][0] + dpSolution(days, i + 1, 0, dp);
        }

        if (last != 1) {
            chooseSecond = days[i][1] + dpSolution(days, i + 1, 1, dp);
        }

        if (last != 2) {
            chooseThird = days[i][2] + dpSolution(days, i + 1, 2, dp);
        }

        return dp[i][last] = Math.max(chooseFirst, Math.max(chooseSecond, chooseThird));
    }

    private static int tabulation(int[][] days) {
        int n = days.length;

        int[][] dp = new int[n + 1][4];

        for (int day = n - 1; day >= 0; day--) {
            for (int last = 3; last >= 0; last--) {

                int chooseFirst = Integer.MIN_VALUE;
                int chooseSecond = Integer.MIN_VALUE;
                int chooseThird = Integer.MIN_VALUE;

                if (last != 0)
                    chooseFirst = days[day][0] + dp[day + 1][0];

                if (last != 1)
                    chooseSecond = days[day][1] + dp[day + 1][1];

                if (last != 2)
                    chooseThird = days[day][2] + dp[day + 1][2];

                dp[day][last] = Math.max(chooseFirst, Math.max(chooseSecond, chooseThird));
            }
        }
        return dp[0][3];
    }

    private static int tabulationOptimized(int[][] days) {
        int n = days.length;

        int[] dp = new int[4];

        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[4];
            for (int last = 3; last >= 0; last--) {

                int chooseFirst = Integer.MIN_VALUE;
                int chooseSecond = Integer.MIN_VALUE;
                int chooseThird = Integer.MIN_VALUE;

                if (last != 0)
                    chooseFirst = days[day][0] + dp[0];

                if (last != 1)
                    chooseSecond = days[day][1] + dp[1];

                if (last != 2)
                    chooseThird = days[day][2] + dp[2];

                curr[last] = Math.max(chooseFirst, Math.max(chooseSecond, chooseThird));
            }
            dp = curr;
        }
        return dp[3];
    }

}