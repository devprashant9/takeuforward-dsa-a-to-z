import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLIS {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println(longestIncreasingSubsequence(arr));
    }

    public static List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        int[] next = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(next, -1);

        int bestStart = 0;
        int bestLen = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[i] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    next[i] = j;
                }
            }

            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestStart = i;
            }
        }

        // reconstruct LIS
        List<Integer> lis = new ArrayList<>();
        for (int i = bestStart; i != -1; i = next[i]) {
            lis.add(arr[i]);
        }

        return lis;
    }
}