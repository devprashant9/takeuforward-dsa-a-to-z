import java.util.Arrays;

public class SelectionSortRecursive {

    public static void selectionSortRecursive(int[] nums, int i) {

        if (i >= nums.length) {
            return;
        }

        int min = findMinimum(nums, i);
        swapNumbers(nums, i, min);
        selectionSortRecursive(nums, i + 1);
    }

    public static int findMinimum(int[] nums, int start) {
        int min = start;
        for (int i = min + 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 3, 1, 4, 4, 0, 2 };
        selectionSortRecursive(nums, 0);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}