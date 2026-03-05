import java.util.Arrays;

public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int length = nums.length;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        int actualSum = (length * (length + 1)) / 2;

        return actualSum - arraySum;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 5 };
        System.out.println("Missing Number in Array is: " + Arrays.toString(nums));
        System.out.println(findMissingNumber(nums));
    }
}