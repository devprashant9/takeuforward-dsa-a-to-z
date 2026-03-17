import java.util.Arrays;

public class SmallestDivisior {

    public static int smallestDivisior(int[] nums, int limit) {
        int low = 1;
        int high = findMaximum(nums);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int divisior = calculateDivisiorSum(nums, mid);
            if (divisior <= limit) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int calculateDivisiorSum(int[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / n);
        }
        return sum;
    }

    public static int findMaximum(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int limit = 8;
        System.out.println("Smallest Divisior Within Threshold Limit is: " + Arrays.toString(nums));
        System.out.println(smallestDivisior(nums, limit));
    }
}