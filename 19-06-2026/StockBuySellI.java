
public class StockBuySellI {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 5, 8, 11, 9 };
        System.out.println(stockBuySell(arr));
    }

    public static int stockBuySell(int[] nums) {
        int min = nums[0];
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            int cost = nums[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, nums[i]);
        }
        return profit;

    }
}
