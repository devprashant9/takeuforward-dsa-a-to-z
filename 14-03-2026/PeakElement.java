import java.util.Arrays;

public class PeakElement {

    public static int peakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean left = (mid == 0) || nums[mid] > nums[mid - 1];
            boolean right = (mid == n - 1) || nums[mid] > nums[mid + 1];

            if (left && right) {
                return mid;
            }

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50, 30, 20, 10 };
        System.out.println("Peak Element in Array is: " + Arrays.toString(nums));
        System.out.println(peakElement(nums));
    }
}