import java.util.Arrays;

public class LeftRotateByOne {

    public static void leftRotateByOne(int[] nums) {
        reverseArray(nums, 1, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 20, 30, 40 };
        System.out.println("Array After 1 Left Rotation is: " + Arrays.toString(nums));
        leftRotateByOne(nums);
        System.out.println(Arrays.toString(nums));
    }
}