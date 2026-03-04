import java.util.Arrays;

public class SortedArrayII {

    public static boolean checkSortedArrayII(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 20, 30, 40 };
        System.out.println("Is This Given Array Sorted: " + Arrays.toString(nums));
        System.out.println(checkSortedArrayII(nums));
    }
}