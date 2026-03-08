import java.util.Arrays;

public class LeftRotateByK {

    public static void leftRotateByK(int[] nums, int K) {
        System.out.println("hi");
        int actualRotations = K % nums.length;
        reverseArray(nums, 0, actualRotations - 1);
        reverseArray(nums, actualRotations, nums.length - 1);
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
        int K = 2;
        System.out.println("Array After Rotations: " + K);
        leftRotateByK(nums, K);
        System.out.println(Arrays.toString(nums));
    }
}