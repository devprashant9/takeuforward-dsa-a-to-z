import java.util.Arrays;

public class OnceAndTwiceAppear {

    public static int numberAppearingTwice(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 2, 4, 4, 5, 5 };
        System.out.println("Once Appearing Number is: " + Arrays.toString(nums));
        System.out.println(numberAppearingTwice(nums));
    }
}