import java.util.Arrays;

public class SplitArrayLargestSum {

    public static int splitArraySum(int[] nums, int k) {
        int low = findMaximum(nums);
        int high = araySum(nums);

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int partitions = countPartitions(nums, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPartitions(int[] nums, int k) {
        int partitions = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= k) {
                sum += nums[i];
            } else {
                partitions += 1;
                sum = nums[i];
            }
        }
        return partitions;
    }

    public static int findMaximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int araySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println("Split Array Sum is: " + Arrays.toString(nums));
        System.out.println(splitArraySum(nums, k));
    }
}