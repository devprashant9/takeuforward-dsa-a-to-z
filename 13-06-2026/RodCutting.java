public class RodCutting {

    public int rodCutting(int price[], int n) {
        return recursive(price, 0, n);
    }

    private static int recursive(int[] price, int i, int target) {
        if (target == 0) {
            return 0;
        }

        if (i == price.length) {
            return 0;
        }

        int notTake = recursive(price, i + 1, target);

        int take = 0;
        int wt = i + 1;
        if (wt <= target) {
            take = price[i] + recursive(price, i, target - wt);
        }

        return Math.max(take, notTake);
    }
}