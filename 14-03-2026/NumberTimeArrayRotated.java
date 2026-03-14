import java.util.Arrays;

public class NumberTimeArrayRotated {

    public static int totalRotations(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[low] <= nums[mid]) {
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println("Array is Rotated: " + Arrays.toString(nums));
        System.out.println(totalRotations(nums));
    }
}