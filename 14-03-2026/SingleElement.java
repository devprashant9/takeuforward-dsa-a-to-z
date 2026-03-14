import java.util.Arrays;

public class SingleElement {

    public static int singleElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 1;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 20, 30, 40, 40, 50, 50, 60, 60, 70, 70 };
        System.out.println("Single Appearing Element is: " + Arrays.toString(nums));
        System.out.println(singleElement(nums));
    }
}