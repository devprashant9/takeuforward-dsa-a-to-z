import java.util.Arrays;

public class InsertionSortRecursive {
    public static void insertionSortRecursive(int[] nums, int start, int end) {

        if (start == end) {
            return;
        }

        int i = start;
        while (i > 0 && nums[i] < nums[i - 1]) {
            swapNumbers(nums, i, i - 1);
            i--;
        }

        insertionSortRecursive(nums, start + 1, end);
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2, 1 };
        insertionSortRecursive(nums, 0, nums.length);
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
    }
}
