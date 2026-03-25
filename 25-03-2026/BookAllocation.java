public class BookAllocation {

    public static int bookAllocation(int[] nums, int m) {
        int low = -1;
        int high = 0;

        // figure out low & high
        for (int num : nums) {
            high += num;
            if (num > low) {
                low = num;
            }
        }

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int totalStudents = allocateBooks(nums, mid);
            if (totalStudents > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int allocateBooks(int[] nums, int pages) {
        int countStudents = 1;
        int totalPages = 0;
        for (int i = 0; i < nums.length; i++) {
            totalPages += nums[i];
            if (totalPages > pages) {
                countStudents++;
                totalPages = nums[i];
            }
        }
        return countStudents;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 34, 67, 90 };
        int k = 2;
        System.out.println("Minimum Pages to be Allocated is: " + bookAllocation(nums, k));
    }
}