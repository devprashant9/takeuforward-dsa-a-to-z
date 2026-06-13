public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int[] price = { 30, 50, 60 };
        int[] wt = { 3, 4, 5 };
        int bag = 8;

        System.out.println(recursive(price, wt, 0, bag));
    }

    private static int recursive(int[] price, int[] wt, int i, int target) {
        if (target == 0) {
            return 0;
        } // As We Have Now Filled The Bag Completely

        if (i == wt.length) {
            return 0;
        } // Two Possibilities The First is Handled By First Base Case So Handle Only
          // Second

        int notTake = recursive(price, wt, i + 1, target);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= target) {
            int res = recursive(price, wt, i + 1, target - wt[i]);
            if (res != Integer.MIN_VALUE) {
                take = price[i] + res;
            }
        }

        return Math.max(take, notTake);
    }
}