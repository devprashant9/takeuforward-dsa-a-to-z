import java.util.Arrays;

public class SecondLargestElement {

    public static int secondLargestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] < largest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 60, 50, 90, 80 };
        System.out.println("Second Largest Element in Array: " + Arrays.toString(nums));
        System.out.println(secondLargestElement(nums));
    }
}