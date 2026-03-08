import java.util.Arrays;

public class LeftRotateByOne {

    public static void leftRotateByOne(int[] nums) {
        reverseArray(nums, 1, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            swapNumbers(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40 };
        System.out.println("Array After Rotations 1 Rotation: ");
        leftRotateByOne(nums);
        System.out.println(Arrays.toString(nums));
    }
}