public class SearchInMatrix {

    public static boolean searchMatrix(int[][] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] <= target && nums[i][nums[i].length - 1] >= target) {
                return binarySearch(nums[i], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == k) {
                return true;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int k = 8;
        System.out.println("The Element is Present in Array: " + searchMatrix(nums, k));
    }
}