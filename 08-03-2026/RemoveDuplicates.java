import java.util.Arrays;

public class RemoveDuplicates {

    public static void removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 4, 4, 5 };
        System.out.println("Array After Removing Duplicats is: " + Arrays.toString(nums));
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}