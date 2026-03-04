import java.util.Arrays;

public class LeftRotateByK {

    public static void leftRotateByK(int[] nums, int K) {
        int actualRotations = K % nums.length;
        if (actualRotations == 0) {
            return;
        } else {
            reverseArray(nums, 0, actualRotations - 1);
            reverseArray(nums, actualRotations, nums.length - 1);
            reverseArray(nums, 0, nums.length - 1);
        }
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
        int K = 25;
        System.out.println("Array After " + K + "Left Rotation is: " + Arrays.toString(nums));
        leftRotateByK(nums, K);
        System.out.println(Arrays.toString(nums));
    }
}