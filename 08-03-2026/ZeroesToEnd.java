import java.util.Arrays;

public class ZeroesToEnd {

    public static void moveZeroesToEnd(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 0 && nums[j] == 0) {
                j--;
            } else if (nums[i] == 0 && nums[j] != 0) {
                swapNumbers(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != 0 && nums[j] == 0) {
                i++;
                j--;
            } else {
                i++;
            }
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 0, 0, 5, 6 };
        System.out.println("After Moving Zeros to End The Array is: " + Arrays.toString(nums));
        moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
}