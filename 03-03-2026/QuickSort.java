import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }

    // Lomuto Parition: we start at i = 0 and j = 0 + 1
    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;

        for (int j = start + 1; j <= end; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 3, 1, 4, 4, 0, 2 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println("Sorted Array is:");
        System.out.println(Arrays.toString(nums));
    }
}