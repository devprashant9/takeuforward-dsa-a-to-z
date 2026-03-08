import java.util.Arrays;

public class SelectionSortRecursive {

    public static void selectionSortRecursive(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int min = findMinimum(nums, start);
        swapNumbers(nums, start, min);
        selectionSortRecursive(nums, start + 1, end);
    }

    public static int findMinimum(int[] nums, int start) {
        int min = start;
        for (int i = start; i < nums.length; i++) {
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
        int[] nums = { 50, 40, 10, 30, 20 };
        System.out.println("Array After Sorting is: " + Arrays.toString(nums));
        selectionSortRecursive(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}