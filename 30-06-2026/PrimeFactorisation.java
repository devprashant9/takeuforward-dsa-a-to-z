import java.util.ArrayList;
import java.util.List;

/**
 * PrimeFactorisation
 */
public class PrimeFactorisation {

    public static void main(String[] args) {
        int[] queries = { 2, 3, 4, 5, 6 };

        System.out.println(primeFactors(queries));
    }

    private static List<List<Integer>> primeFactors(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] spf = getSieve(getMaximum(nums));

        for (int num : nums) {
            int temp = num;
            List<Integer> list = new ArrayList<>();
            while (temp != 1) {
                list.add(spf[temp]);
                temp = temp / spf[temp];
            }
            ans.add(list);
        }
        return ans;
    }

    private static int getMaximum(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int[] getSieve(int max) {
        int[] spf = new int[max + 1];

        // Sieve Variation
        for (int i = 2; i <= max; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }

        }
        return spf;
    }
}