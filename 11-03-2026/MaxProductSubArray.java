import java.util.Arrays;

public class MaxProductSubArray {

    public static int maxSubarrayProduct(int[] nums) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];

            max = Math.max(max, Math.max(prefixProduct, suffixProduct));

            if(prefixProduct == 0) {
                prefixProduct = 1;
            }

            if(suffixProduct == 0) {
                suffixProduct = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -4, -3};
        System.out.println("Maximum Subarray Product is: " +Arrays.toString(nums));
        System.out.println(maxSubarrayProduct(nums));
    }
}