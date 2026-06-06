import java.util.Arrays;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibonacciNumber(n));
        System.out.println(memoization(n));
        System.out.println(tabulation(n));
        System.out.println(tabulationOptimized(n));
    }

    private static int fibonacciNumber(int n) {
        if (n == 1 || n == 0)
            return n;
        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
    }

    private static int memoization(int n) {
        if (n == 1 || n == 0)
            return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return memoizeHelper(n, dp);
    }

    private static int memoizeHelper(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        if (n == 1 || n == 0)
            return n;

        return dp[n] = memoizeHelper(n - 1, dp) + memoizeHelper(n - 2, dp);
    }

    private static int tabulation(int n) {
        if (n == 1 || n == 0)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    private static int tabulationOptimized(int n) {
        if (n == 1 || n == 0)
            return n;

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;

            prev = curr;
            curr = sum;
        }

        return curr;
    }

}
