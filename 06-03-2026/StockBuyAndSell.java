class StockBuyAndSell {

    public static int stockBuySell(int[] nums, int n) {
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