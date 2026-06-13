public class TargetSum {

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return recursive(val, wt, 0, W);
    }

    private static int recursive(int[] price, int[] wt, int i, int target) {
        if (target == 0) {
            return 0;
        }

        if (i == wt.length) {
            return 0;
        }

        int notTake = recursive(price, wt, i + 1, target);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= target) {
            int res = recursive(price, wt, i, target - wt[i]);
            if (res != Integer.MIN_VALUE) {
                take = price[i] + res;
            }
        }

        return Math.max(take, notTake);
    }
}