import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int originalSum = 0;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        originalSum = (nums.length * (nums.length + 1)) / 2;
        return originalSum - arraySum;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 5, 6 };
        System.out.println("Missing Number in Array is: " + Arrays.toString(nums));
        System.out.println(missingNumber(nums));
    }
}