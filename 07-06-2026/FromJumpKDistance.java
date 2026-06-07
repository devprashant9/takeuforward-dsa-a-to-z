import java.util.Arrays;

public class FromJumpKDistance {

    private static int recursive(int[] heights, int i, int k) {
        int n = heights.length;

        if (i >= n)
            return Integer.MAX_VALUE;
        if (i == (n - 1))
            return 0;

        int minEnergyStep = Integer.MAX_VALUE;
        for (int steps = 1; steps <= k; steps++) {
            if (i + steps < n) {
                int futureEnergy = recursive(heights, i + steps, k);

                if (futureEnergy != Integer.MAX_VALUE) {
                    int currentStepEnergy = Math.abs(heights[i] - heights[i + steps]) + futureEnergy;
                    minEnergyStep = Math.min(minEnergyStep, currentStepEnergy);
                }
            }
        }

        return minEnergyStep;
    }

    private static int dpSolution(int[] heights, int i, int k, int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int n = heights.length;

        if (i == (n - 1))
            return dp[i] = 0;

        int minEnergyStep = Integer.MAX_VALUE;
        for (int steps = 1; steps <= k; steps++) {
            if (i + steps < n) {
                int futureEnergy = dp[i + steps] == -1 ? dpSolution(heights, i + steps, k, dp) : dp[i + steps];

                if (futureEnergy != Integer.MAX_VALUE) {
                    int currentStepEnergy = Math.abs(heights[i] - heights[i + steps]) + futureEnergy;
                    minEnergyStep = Math.min(minEnergyStep, currentStepEnergy);
                }
            }
        }

        return dp[i] = minEnergyStep;
    }

    // We Can Look on Left & Right Both But Looking Left is More Intuitive As We
    // Build From Left to right
    private static int tabulation(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int steps = 1; steps <= k; steps++) {
                if (i + steps < n) {
                    dp[i + steps] = Math.min(dp[i + steps], dp[i] + Math.abs(heights[i] - heights[i + steps]));
                }
            }
        }

        return dp[n - 1];
    }

    private static int tabulationOptimized(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[k];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int current = Integer.MAX_VALUE;
            for (int steps = 1; steps <= k; steps++) {
                if (i - steps >= 0) {
                    int prevDp = dp[(i - steps) % k];

                    current = Math.min(
                            current,
                            prevDp + Math.abs(heights[i] - heights[i - steps]));
                }
            }

            dp[i % k] = current;
        }

        return dp[(n - 1) % k];
    }

    public static void main(String[] args) {
        int[] steps = { 10, 5, 20, 0, 15 };
        int k = 2;

        System.out.println(recursive(steps, 0, k));

        int n = steps.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(dpSolution(steps, 0, k, dp));

        System.out.println(tabulation(steps, k));
        System.out.println(tabulationOptimized(steps, k));
    }
}