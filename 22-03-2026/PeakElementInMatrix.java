import java.util.Arrays;

public class PeakElementInMatrix {

    public static int[] peakElementII(int[][] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int row = rowWithMaxValue(nums, mid);

            int left = mid - 1 >= 0 ? nums[row][mid - 1] : -1;
            int right = mid + 1 < nums.length ? nums[row][mid + 1] : -1;

            if (nums[row][mid] > left && nums[row][mid] > right) {
                return new int[] { row, mid };
            } else if (nums[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static int rowWithMaxValue(int[][] nums, int col) {
        int max = -1;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][col] > max) {
                max = nums[i][col];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 10, 20, 15 },
                { 21, 30, 14 },
                { 17, 16, 32 }
        };
        System.out.println("Peak Element in Array is: ");
        System.out.println(Arrays.toString(peakElementII(nums)));
    }
}