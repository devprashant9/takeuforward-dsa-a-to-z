/**
 * SingleNumberII
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 3, 5, 5, 1, 1, 5, 1 };
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}