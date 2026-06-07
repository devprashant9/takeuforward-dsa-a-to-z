import java.util.Arrays;

public class ClimbStairs {

    private static int recursive(int n) {
        if (n == 2 || n == 1 || n == 0)
            return n;
        return recursive(n - 1) + recursive(n - 2);
    }

    private static int dpSolution(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        if (n == 2 || n == 1 || n == 0)
            return n;

        return dp[n] = dpSolution(n - 1, dp) + dpSolution(n - 2, dp);
    }

    private static int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    private static int tabulationOptimization(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        int prev = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;

            prev = curr;
            curr = sum;
        }

        return curr;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(recursive(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(dpSolution(n, dp));

        System.out.println(tabulation(n));
        System.out.println(tabulationOptimization(n));
    }
}