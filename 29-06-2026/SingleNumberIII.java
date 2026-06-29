import java.util.Arrays;

/**
 * SingleNumberIII
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 4, 1, 1, 5, 6, 6 };
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    private static int[] singleNumber(int[] nums) {
        int totalXor = 0;
        for (int num : nums)
            totalXor ^= num;

        int rightMostSetBit = totalXor & -totalXor;

        int bkt_1 = 0, bkt_2 = 0;
        for (int num : nums) {
            if ((num & rightMostSetBit) == 1) {
                bkt_1 ^= num;
            } else {
                bkt_2 ^= num;
            }
        }
        return new int[] { bkt_1, bkt_2 };
    }
}