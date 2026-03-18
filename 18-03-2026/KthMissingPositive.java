import java.util.Arrays;

public class KthMissingPositive {

    public static int findKthPositive(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int missing = nums[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 7, 10 };
        int k = 6;
        System.out.println("Kth Missing Number in Array is: " + Arrays.toString(nums));
        System.out.println(findKthPositive(nums, k));
    }
}