import java.util.Arrays;

public class LowerBound {

    public static int lowerBound(int[] nums, int X) {
        int lowerBound = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] >= X) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int X = 15;
        System.out.println("Lower Bound For Given Element in Array is: " + Arrays.toString(nums));
        System.out.println(lowerBound(nums, X));
    }
}