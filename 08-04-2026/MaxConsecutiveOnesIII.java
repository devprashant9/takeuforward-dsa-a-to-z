public class MaxConsecutiveOnesIII {

    public static int maxConsecutiveOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        int maxOnes = 0;

        while (j < n) {
            if (nums[j] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }

            maxOnes = Math.max(maxOnes, j - i + 1);
            j++;
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        System.out.println("Length of Subarray With Max Consecutive Ones is: " + maxConsecutiveOnes(nums, k));
    }
}