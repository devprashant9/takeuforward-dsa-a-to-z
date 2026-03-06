import java.util.Arrays;

public class SortZeroOneTwo {

    public static void sortZeroOneTwo(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 1, 0 };
        System.out.println("Sorted Array is: ");
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));
    }
}