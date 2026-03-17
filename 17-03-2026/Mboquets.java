import java.util.Arrays;

public class Mboquets {

    public static int mBoquets(int[] nums, int m, int k) {
        int low = 1;
        int high = findMaximum(nums);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int numberOfBoquets = calculateBoquets(nums, k, mid);
            if (numberOfBoquets < m) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int calculateBoquets(int[] nums, int k, int n) {
        int boquets = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                cnt += 1;
            }
            if (nums[i] > n) {
                cnt = 0;
            }
            if (cnt == k) {
                boquets += 1;
                cnt = 0;
            }
        }
        return boquets;
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
        int[] nums = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2;
        int k = 3;
        System.out.println("Minimum Days to Make M Boquets: " + Arrays.toString(nums));
        System.out.println(mBoquets(nums, m, k));
    }
}