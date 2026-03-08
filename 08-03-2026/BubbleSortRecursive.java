import java.util.Arrays;

public class BubbleSortRecursive {

    public static void bubbleSortRecursive(int[] nums) {
        bubbleSortHelper(nums, 0, nums.length);
    }

    public static void bubbleSortHelper(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }

        for (int j = 0; j < end - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                swapNumbers(nums, j, j + 1);
            }
        }
        bubbleSortHelper(nums, start, end - 1);
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        bubbleSortRecursive(nums);
        System.out.println(Arrays.toString(nums));
    }
}