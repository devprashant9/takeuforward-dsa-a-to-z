import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swapNumbers(nums, j, j - 1);
                j--;
            }
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2, 1 };
        insertionSort(nums);
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
    }
}