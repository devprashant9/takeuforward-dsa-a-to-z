import java.util.Arrays;

public class FrogJump {

    private static int recursive(int[] heights, int i) {
        int n = heights.length;

        if (i >= heights.length)
            return Integer.MAX_VALUE;
        if (i == heights.length - 1)
            return 0;

        // Try All Ways Dont Apply Greedy Brain Here It Already Failed

        int oneSteps = Integer.MAX_VALUE;
        int twoSteps = Integer.MAX_VALUE;
        if (i + 1 < n)
            oneSteps = Math.abs(heights[i] - heights[i + 1]) + recursive(heights, i + 1);

        if (i + 2 < n)
            twoSteps = Math.abs(heights[i] - heights[i + 2]) + recursive(heights, i + 2);

        return Math.min(oneSteps, twoSteps);
    }

    private static int dpSolution(int[] heights, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int n = heights.length;

        if (i >= heights.length)
            return Integer.MAX_VALUE;
        if (i == heights.length - 1)
            return 0;

        // Try All Ways Dont Apply Greedy Brain Here It Already Failed

        int oneSteps = Integer.MAX_VALUE;
        int twoSteps = Integer.MAX_VALUE;
        if (i + 1 < n)
            oneSteps = Math.abs(heights[i] - heights[i + 1]) + dpSolution(heights, i + 1, dp);

        if (i + 2 < n)
            twoSteps = Math.abs(heights[i] - heights[i + 2]) + dpSolution(heights, i + 2, dp);

        return dp[i] = Math.min(oneSteps, twoSteps);
    }

    private static int tabulation(int[] heights) {
        int n = heights.length;

        int[] dp = new int[n];
        dp[n - 1] = 0; // 0 Steps
        dp[n - 2] = Math.abs(heights[n - 1] - heights[n - 2]); // Only 1 Possible Step

        for (int i = n - 3; i >= 0; i--) {
            int oneSteps = Math.abs(heights[i] - heights[i + 1]);
            int twoSteps = Math.abs(heights[i] - heights[i + 2]);

            dp[i] = Math.min(oneSteps, twoSteps);
        }

        return dp[0];
    }

    private static int tabulationOptimization(int[] heights) {
        int n = heights.length;

        int last = 0; // dp[i+1]
        int secondLast = 0; // dp[i+2]

        for (int i = n - 2; i >= 0; i--) {

            int oneStep = Math.abs(heights[i] - heights[i + 1]) + last;

            int twoStep = Integer.MAX_VALUE;
            if (i + 2 < n) {
                twoStep = Math.abs(heights[i] - heights[i + 2]) + secondLast;
            }

            int ans = Math.min(oneStep, twoStep);

            secondLast = last;
            last = ans;
        }

        return last;
    }

    public static void main(String[] args) {
        int[] steps = { 2, 1, 3, 5, 4 };

        System.out.println(recursive(steps, 0));

        int n = steps.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(dpSolution(steps, 0, dp));

        System.out.println(tabulation(steps));
        System.out.println(tabulationOptimization(steps));
    }
}