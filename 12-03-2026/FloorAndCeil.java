import java.util.Arrays;

public class FloorAndCeil {

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

    public static int[] floorAndCeil(int[] nums, int X) {
        int lb = lowerBound(nums, X);
        int ub = lowerBound(nums, X);

        int floor = -1;
        int ceil = -1;

        if (lb != -1) {
            ceil = nums[lb];
        }

        if (ub > 0) {
            floor = nums[ub - 1];
        }
        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 7, 8, 10 };
        int X = 5;
        System.out.println("Floor and Ceil For Given Element is: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(floorAndCeil(nums, X)));
    }
}