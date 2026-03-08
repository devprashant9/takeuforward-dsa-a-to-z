import java.util.Arrays;

public class SortedArrayII {

    public static boolean checkSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 30, 40 };
        System.out.println("Given Array is Sorted: " + Arrays.toString(nums));
        System.out.println(checkSorted(nums));
    }
}