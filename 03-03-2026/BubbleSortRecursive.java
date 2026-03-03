import java.util.Arrays;

public class BubbleSortRecursive {

    public static void bubbleSortRecursive(int[] nums, int i) {

        if (i >= nums.length) {
            return;
        }

        for (int j = 0; j < nums.length - i - 1; j++) {
            if(nums[j] > nums[j + 1]) {
                swapNumbers(nums, j, j + 1);
            }
        }
        bubbleSortRecursive(nums, i + 1);
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 3, 1, 4, 4, 0, 2 };
        bubbleSortRecursive(nums, 0);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(nums));
    }
}