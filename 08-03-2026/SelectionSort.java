import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = findMinimum(nums, i + 1);
            swapNumbers(nums, i, min);
        }
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
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}