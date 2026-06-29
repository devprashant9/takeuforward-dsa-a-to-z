/**
 * SingleNumberI
 */
public class SingleNumberI {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 4, 5, 1, 1, 5, 6, 6 };
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }
}