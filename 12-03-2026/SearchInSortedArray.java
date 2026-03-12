import java.util.Arrays;

public class SearchInSortedArray {

    public static boolean binarySearch(int[] nums, int X) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == X) {
                return true;
            } else if (nums[mid] > X) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int X = 20;
        System.out.println("Given Element is Present in Array: " + Arrays.toString(nums));
        System.out.println(binarySearch(nums, X));
    }
}