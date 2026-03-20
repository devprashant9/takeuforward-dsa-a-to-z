public class RowWithMaxOnes {

    public static int maxRow(int[][] nums) {
        int idx = -1;
        int maxOnesCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int onesCount = nums[i].length - lowerBound(nums[i], 1);
            if (onesCount > maxOnesCount) {
                maxOnesCount = onesCount;
                idx = i;
            }
        }
        return idx;
    }

    public static int lowerBound(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 }
        };
        System.out.println("Row With Maximum 1's is: " + maxRow(nums));
    }
}