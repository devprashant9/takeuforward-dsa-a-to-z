import java.util.Arrays;

public class CyclicSort {

    public static void cyclicSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swapNumbers(nums, i, nums[i] - 1);
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
        cyclicSort(nums);
        System.out.println("Sorted Array is: " + Arrays.toString(nums));
    }
}