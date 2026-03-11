import java.util.Arrays;

public class MissingAndRepeatingNumber {

    public static int[] missingAndRepeating(int[] nums) {

        int n = nums.length;

        int arraySum = 0;
        int arraySumSquares = 0;
        int actualArraySum = (n * (n + 1)) / 2;
        int actualArraySumSquares = (n * (n + 1) * ((2 * n) + 1)) / 6;

        for (int num : nums) {
            arraySum += num;
            arraySumSquares += num * num;
        }

        int xMinusY = arraySum - actualArraySum;
        int xPlusY = (arraySumSquares - actualArraySumSquares) / xMinusY;

        int repeatingNumber = (xPlusY - xMinusY) / 2;
        int missingNumber = repeatingNumber - xMinusY;

        return new int[] { repeatingNumber, missingNumber };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 6, 7, 5, 7 };
        System.out.println("Missing and Repeating Number in Array is: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(missingAndRepeating(nums)));
    }
}