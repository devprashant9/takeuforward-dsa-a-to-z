import java.util.Arrays;

public class ZeroesToEnd {

    public static void moveZeroesToEnd(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            } else if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[i] != 0 && nums[j] == 0) {
                i++;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 10, 0, 20, 0, 30, 0 };
        System.out.println("Array After Moving Zeroes To End: " + Arrays.toString(nums));
        moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
}