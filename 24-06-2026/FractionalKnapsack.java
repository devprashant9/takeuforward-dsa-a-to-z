import java.util.Arrays;

public class FractionalKnapsack {

    static class Items {
        private int wt;
        private int val;
        private double perUnitVal;

        Items(int wt, int val) {
            this.wt = wt;
            this.val = val;
            this.perUnitVal = (double) (val / wt);
        }
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int capacity = 50;

        System.out.println(maxProfit(wt, val, capacity));
    }

    private static double maxProfit(int[] wt, int[] val, int capacity) {
        Items[] item = new Items[wt.length];
        for (int i = 0; i < wt.length; i++) {
            item[i] = new Items(wt[i], val[i]);
        }

        Arrays.sort(item, (a, b) -> Double.compare(b.perUnitVal, a.perUnitVal));

        int profit = 0;
        for (Items i : item) {
            if (capacity >= i.wt) {
                profit += i.val;
                capacity -= i.wt;
            } else {
                profit += capacity * i.perUnitVal;
                break;
            }
        }
        return profit;
    }
}