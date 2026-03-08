import java.util.Arrays;

public class MajorityElementI {

    public static int majorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count += 1;
            } else {
                count -= 1;
                if (count == 0) {
                    majorityElement = nums[i];
                    count++;
                }
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 10, 20, 20, 20, 10 };
        System.out.println("Majority Element in Array is: " + Arrays.toString(nums));
        System.out.println(majorityElement(nums));
    }
}