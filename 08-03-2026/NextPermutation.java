import java.util.Arrays;

public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {
        int breakPoint = -1;
        int greaterInSubarray = 0;

        // Step 1: find breakPoint i.e. dip
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i - 1] < nums[i]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i > breakPoint; i--) {
                if (nums[i] > nums[breakPoint] && nums[i] < nums[i - 1]) {
                    greaterInSubarray = i;
                    break;
                }
            }
            swapNumbers(nums, breakPoint, greaterInSubarray);
        }
        return nums;
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
        int[] nums = { 1, 2, 3 };
        System.out.println("Next Permutation of Array is: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }
}