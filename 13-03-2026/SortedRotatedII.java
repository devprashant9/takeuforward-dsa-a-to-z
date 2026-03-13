import java.util.Arrays;

public class SortedRotatedII {

    public static int sortedRotatedII(int[] nums, int K) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == K) {
                return mid;
            } else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low += 1;
                high -= 1;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= K && K <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= K && K <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 60, 70, 70, 70, 10, 20, 30, 40, 50 };
        int K = 40;
        System.out.println("Element is Prsent in Array: " + Arrays.toString(nums));
        System.out.println(sortedRotatedII(nums, K));
    }
}