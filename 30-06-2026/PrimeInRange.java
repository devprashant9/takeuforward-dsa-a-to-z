import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PrimeInRange
 */
public class PrimeInRange {

    public static void main(String[] args) {
        int[][] ranges = { { 1, 7 }, { 3, 7 } };

        System.out.println(countPrimes(ranges));
    }

    private static List<Integer> countPrimes(int[][] ranges) {
        List<Integer> ans = new ArrayList<>();
        int[] sieve = getSieve(getMaximum(ranges));

        for (int[] range : ranges) {
            int left = range[0];
            int right = range[1];

            if (left == 0) {
                ans.add(sieve[right]);
            } else {
                ans.add(sieve[right] - sieve[left - 1]);
            }
        }

        return ans;
    }

    private static int getMaximum(int[][] ranges) {
        int max = 0;
        for (int[] num : ranges) {
            max = Math.max(max, Math.max(num[0], num[1]));
        }
        return max;
    }

    private static int[] getSieve(int max) {
        int[] sieve = new int[max + 1];

        Arrays.fill(sieve, 1);

        sieve[0] = 0;
        if (max >= 1) {
            sieve[1] = 0;
        }

        for (int i = 2; i * i <= max; i++) {
            if (sieve[i] == 1) {
                for (int j = i * i; j <= max; j += i) {
                    sieve[j] = 0;
                }
            }
        }

        return prefixSum(sieve);
    }

    private static int[] prefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}