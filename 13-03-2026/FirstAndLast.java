import java.util.Arrays;

public class FirstAndLast {

    public static int[] firstAndLast(int[] nums, int K) {
        int first = lowerBound(nums, K);
        if (first == nums.length || nums[first] != K) {
            return new int[] { -1, -1 };
        }
        return new int[] { first, upperBound(nums, K) - 1 };
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
        int[] nums = { 1, 2, 3, 4, 5, 5, 5, 6, 7, 8 };
        int K = 5;
        System.out.println("First & Last Occurrence of " + K + " in Array: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(firstAndLast(nums, K)));
    }
}