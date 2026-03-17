import java.util.Arrays;

public class ShipPackagesDays {

    public static int shipPackages(int[] nums, int days) {
        int low = 1;
        int high = findMaximumCapacity(nums);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int numberOfDays = calculateDays(nums, mid);
            if (numberOfDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int calculateDays(int[] nums, int capacity) {
        int weight = 0;
        int days = 1;
        for (int i = 0; i < nums.length; i++) {
            weight += nums[i];
            if (weight > capacity) {
                days += 1;
                weight = nums[i];
            }
        }
        return days;
    }

    public static int findMaximumCapacity(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println("Maximum Capacity of The Ship is: " + Arrays.toString(nums));
        System.out.println(shipPackages(nums, days));
    }
}