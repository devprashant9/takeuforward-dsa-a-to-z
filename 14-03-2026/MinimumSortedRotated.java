import java.util.Arrays;

public class MinimumSortedRotated {

    public static int minimumInSortedArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 60, 70, 80, 10, 20, 30, 40, 50 };
        System.out.println("Minimum in Array is: " + Arrays.toString(nums));
        System.out.println(minimumInSortedArray(nums));
    }
}