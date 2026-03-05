import java.util.Arrays;

class LinearSearch {

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 30, 50, 40, 60, 90 };
        int target = 40;
        System.out.println(target + " is Present in Array At Position: " + Arrays.toString(nums));
        System.out.println(linearSearch(nums, target));
    }
}