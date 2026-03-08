import java.util.Arrays;

public class SortZeroOneTwo {

    public static void sortArray(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid < high) {
            if (nums[mid] == 0) {
                swapNumbers(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swapNumbers(nums, mid, high);
                high--;
            }
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 0, 2, 1, 0 };
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}