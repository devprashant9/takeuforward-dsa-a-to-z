import java.util.Arrays;

public class HouseRobberII {

    private static int recursive(int[] money, int i, int end) {
        if (i > end)
            return 0;

        int take = money[i] + recursive(money, i + 2, end);
        int skip = recursive(money, i + 1, end);

        return Math.max(take, skip);
    }

    private static int dpSolution(int[] money, int i, int end, int[] dp) {
        if (i > end)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int take = money[i] + dpSolution(money, i + 2, end, dp);
        int skip = dpSolution(money, i + 1, end, dp);

        return dp[i] = Math.max(take, skip);
    }

    private static int tabulation(int[] money, int start, int end) {
        int n = money.length;
        int[] dp = new int[n + 2];

        for (int i = end; i >= start; i--) {
            int take = money[i] + dp[i + 2];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }
        return dp[start];
    }

    public static void main(String[] args) {
        int[] money = { 2, 1, 4, 9 };
        int n = money.length;

        System.out.println(Math.max(recursive(money, 0, n - 2), recursive(money, 1, n - 1)));

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int startFromZero = dpSolution(money, 0, n - 2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int startFromOne = dpSolution(money, 0, n - 1, dp2);
        System.out.println(Math.max(startFromZero, startFromOne));

        int startfromZeroI = tabulation(money, 0, n - 2);
        int startfromOneI = tabulation(money, 1, n - 1);
        System.out.println(Math.max(startfromZeroI, startfromOneI));
    }
}