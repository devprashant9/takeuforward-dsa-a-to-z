import java.util.Arrays;

public class AggresiveCows {

    public static int aggresiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length - 1] - nums[0];

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (canWePlace(nums, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] nums, int dist, int cows) {
        int cowsPlaced = 1;
        int prevDistance = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - prevDistance >= dist) {
                cowsPlaced += 1;
                prevDistance = nums[i];
            }
        }
        if (cowsPlaced >= cows) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println("Maximum Minimum Distance Between Cows Are: " + Arrays.toString(nums));
        System.out.println(aggresiveCows(nums, k));
    }
}