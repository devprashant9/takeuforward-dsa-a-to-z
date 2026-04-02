public class TrappingRainWater {

    public static int trapRainWater(int[] nums) {
        int n = nums.length;
        int totalWater = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            if (nums[left] <= nums[right]) {
                if (leftMax > nums[left]) {
                    totalWater += leftMax - nums[left];
                } else {
                    leftMax = nums[left];
                }
                left++;
            } else {
                if (rightMax > nums[right]) {
                    totalWater += rightMax - nums[right];
                } else {
                    rightMax = nums[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Total Water Stored is: " + trapRainWater(nums));
    }
}