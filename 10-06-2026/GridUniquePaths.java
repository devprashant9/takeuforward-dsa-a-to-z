import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GridUniquePaths {

    public record Pair<K, V>(K first, V second) {
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        int[][] mat = new int[m][n];

        System.out.println(dfsRecursive(mat, 0, 0));

        int[][] dp = new int[m + 1][n + 1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(dpSolution(mat, 0, 0, dp));

        System.out.println(tabulation(mat, m, n));
        System.out.println(tabulationOptimized(mat));
        System.out.println(bfsTraversal(mat, m, n));
    }

    private static boolean checkBound(int[][] mat, int m, int n) {
        if (m < 0 || m >= mat.length) {
            return false;
        }

        if (n < 0 || n >= mat[0].length) {
            return false;
        }

        return true;
    }

    private static int dfsRecursive(int[][] mat, int m, int n) {
        if (!checkBound(mat, m, n)) {
            return 0;
        }

        if (m == mat.length - 1 && n == mat[0].length - 1) {
            return 1;
        }

        int stepRight = dfsRecursive(mat, m, n + 1);
        int stepDown = dfsRecursive(mat, m + 1, n);

        return stepRight + stepDown;
    }

    private static int dpSolution(int[][] mat, int m, int n, int[][] dp) {
        if (!checkBound(mat, m, n)) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (m == mat.length - 1 && n == mat[0].length - 1) {
            return 1;
        }

        int stepRight = dpSolution(mat, m, n + 1, dp);
        int stepDown = dpSolution(mat, m + 1, n, dp);

        return dp[m][n] = stepRight + stepDown;
    }

    private static int tabulation(int[][] mat, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int stepRight = dp[i][j + 1];
                int stepDown = dp[i + 1][j];

                dp[i][j] = stepRight + stepDown;
            }
        }
        return dp[0][0];
    }

    private static int tabulationOptimized(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int[] nextRow = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            int[] currentRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    currentRow[j] = 1;
                    continue;
                }

                int stepRight = (j + 1 < n) ? currentRow[j + 1] : 0;
                int stepDown = nextRow[j];

                currentRow[j] = stepRight + stepDown;
            }
            nextRow = currentRow;
        }
        return nextRow[0];
    }

    private static int bfsTraversal(int[][] mat, int m, int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));

        int totalWays = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.remove();
            int r = current.first();
            int c = current.second();

            if (r == m - 1 && c == n - 1) {
                totalWays++;
                continue;
            }

            if (r + 1 < m) {
                q.add(new Pair<>(r + 1, c));
            }

            if (c + 1 < n) {
                q.add(new Pair<>(r, c + 1));
            }
        }
        return totalWays;
    }
}