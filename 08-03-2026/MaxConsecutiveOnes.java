import java.util.Arrays;

public class MaxConsecutiveOnes {

    public static int longestConsecutiveSequence(int[] nums) {
        int maxOnesCount = 0;
        int currentCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount += 1;
                maxOnesCount = Math.max(maxOnesCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        return maxOnesCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 0, 1, 0, 1, 1, 1 };
        System.out.println("Longest Consecutive Sequence is: " + Arrays.toString(nums));
        System.out.println(longestConsecutiveSequence(nums));
    }
}