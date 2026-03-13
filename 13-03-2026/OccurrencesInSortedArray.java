import java.util.Arrays;

public class OccurrencesInSortedArray {

    public static int countOccurrences(int[] nums, int K) {
        int lb = lowerBound(nums, K);
        int ub = upperBound(nums, K);

        if (lb == nums.length || nums[lb] != K) {
            return -1;
        }
        return ub - lb;
    }

    public static int lowerBound(int[] nums, int x) {
        int lb = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] >= x) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }

    public static int upperBound(int[] nums, int x) {
        int ub = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] > x) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4, 4, 4, 5, 6 };
        int K = 9;
        System.out.println("Count of " + K + " in Array is: " + Arrays.toString(nums));
        System.out.println(countOccurrences(nums, K));
    }
}