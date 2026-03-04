import java.util.Arrays;

public class LargestElement {

    public static int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 60, 50, 90, 80 };
        System.out.println("Largest Element in Array: " + Arrays.toString(nums));
        System.out.println(largestElement(nums));
    }
}