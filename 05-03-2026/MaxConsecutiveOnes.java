import java.util.Arrays;

public class MaxConsecutiveOnes {

    public static int maxConsecutiveOnes(int[] nums) {
        int onesCount = 0;
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                onesCount++;
                maxOnes = Math.max(onesCount, maxOnes);
            } else {
                onesCount = 0;
            }
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 0, 1, 1, 1, 1 };
        System.out.println("Maximum Consecutive 1's in Array is: " + Arrays.toString(nums));
        System.out.println(maxConsecutiveOnes(nums));
    }
}