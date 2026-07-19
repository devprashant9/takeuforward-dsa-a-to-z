
public class PartionMaxSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return solve(0, arr, k);
    }

    int solve(int i, int[] arr, int k) {

        if (i == arr.length)
            return 0;

        int maxSum = 0;
        int currentMax = 0;

        for (int j = i; j < Math.min(arr.length, i + k); j++) {

            currentMax = Math.max(currentMax, arr[j]);

            int length = j - i + 1;

            int sum = length * currentMax + solve(j + 1, arr, k);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}