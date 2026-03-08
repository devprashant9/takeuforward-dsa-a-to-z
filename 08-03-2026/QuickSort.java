import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionIndex(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }

    public static int partitionIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;

        for (int j = start + 1; j <= end; j++) {
            if (nums[j] < pivot) {
                i++;
                swapNumbers(nums, i, j);
            }
        }
        swapNumbers(nums, start, i);
        return i;
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 30, 20, 40, 80, 60 };
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}