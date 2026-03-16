import java.util.Arrays;

public class KokoEatingBananas {

    public static int calculateTime(int[] nums, int n, int K) {
        int timeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            timeCount = (int) Math.ceil((double) nums[i] / n);
            K -= timeCount;
        }
        return K;
    }

    public static int minimumTime(int[] nums, int K) {
        int low = 1;
        int high = findMaximum(nums);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int minTime = calculateTime(nums, mid, K);
            if (minTime < 0) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findMaximum(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 15, 6, 3 };
        int K = 8;
        System.out.println("Koko Should Eat : " + Arrays.toString(nums));
        System.out.println(minimumTime(nums, K));
    }
}