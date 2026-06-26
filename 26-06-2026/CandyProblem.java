
public class CandyProblem {

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 5 };
        int n = ratings.length;

        int[] left = new int[n];
        left = leftNeighbourCandies(ratings, n, left);

        int[] right = new int[n];
        right = rightNeighbourCandies(ratings, n, right);

        System.out.println(maxCandies(left, right, n));
        System.out.println(betterSolution(left, n, ratings));
        System.out.println(optimal(ratings, n));
    }

    private static int[] leftNeighbourCandies(int[] ratings, int n, int[] left) {
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }
        return left;
    }

    private static int[] rightNeighbourCandies(int[] ratings, int n, int[] right) {
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }
        return right;
    }

    private static int maxCandies(int[] left, int[] right, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.max(left[i], right[i]);
        }
        return sum;
    }

    private static int betterSolution(int[] left, int n, int[] ratings) {
        int rightMax = 1; // righmost
        int sum = left[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightMax = rightMax + 1;
            } else {
                rightMax = 1;
            }
            sum += Math.max(left[i], rightMax);
        }
        return sum;
    }

    private static int optimal(int[] ratings, int n) {
        int i = 1;
        int sum = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum = sum + 1;
                i++;
                continue;
            }

            // Loop through increasing ratings trend
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;
                i++;
            }

            // Loop through decreasing ratings trend
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;
            }

            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }
}