import java.util.Arrays;

public class StockBuyAndSell {

    public static int stockBuyAndSell(int[] nums) {
        int buy = nums[0];
        int maxProfit = 0;
        for (int i = 1; i < nums.length; i++) {
            int currentProfit = nums[i] - buy;
            maxProfit = Math.max(maxProfit, currentProfit);
            buy = Math.min(nums[i], buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 5, 8, 11, 9 };
        System.out.println("Maximum Profit After Buying and Selling Stock is: " + Arrays.toString(nums));
        System.out.println(stockBuyAndSell(nums));
    }
}