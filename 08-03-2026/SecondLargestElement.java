import java.util.Arrays;

public class SecondLargestElement {

    public static int secondLargest(int[] nums) {
        int largest = 0;
        int secondLargest = 0;
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
        int[] nums = { 60, 20, 10, 30, 50 };
        System.out.println("Second Largest Elemet is: " + Arrays.toString(nums));
        System.out.println(secondLargest(nums));
    }
}