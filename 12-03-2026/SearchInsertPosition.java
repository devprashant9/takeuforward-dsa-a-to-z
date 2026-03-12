import java.util.Arrays;

public class SearchInsertPosition {

    public static int upperBound(int[] nums, int X) {
        int upperBound = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] > X) {
                upperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int X = 25;
        System.out.println("Insert Position of Element in Array is: " + Arrays.toString(nums));
        System.out.println(upperBound(nums, X));
    }
}