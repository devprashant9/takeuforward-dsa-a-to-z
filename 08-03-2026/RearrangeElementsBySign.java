import java.util.Arrays;

public class RearrangeElementsBySign {

    public static int[] arrangeBySign(int[] nums) {
        int positive = 0;
        int negative = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[negative] = nums[i];
                negative += 2;
            } else {
                ans[positive] = nums[i];
                positive += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -10, -20, -40, 30, 50, 60 };
        System.out.println("Array After Arranging is: " + Arrays.toString(nums));
        System.out.println(Arrays.toString(arrangeBySign(nums)));
    }
}