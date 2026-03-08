import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swapNumbers(nums, j, j + 1);
                }
            }
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}