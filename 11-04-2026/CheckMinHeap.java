public class CheckMinHeap {

    public static boolean isMinHeap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 1;

            if (left < n && nums[i] > nums[left]) {
                return false;
            }

            if (right < n && nums[i] > nums[right]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 21, 23 };
        System.out.println("Given Array Represents Min Heap? " + isMinHeap(nums));
    }
}