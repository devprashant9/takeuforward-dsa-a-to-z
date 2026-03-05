import java.util.Arrays;

public class OnceAndTwiceAppear {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 30, 20, 40, 40 };
        System.out.println("Number Appearing Once in Array is: " + Arrays.toString(nums));
        System.out.println(singleNumber(nums));
    }
}