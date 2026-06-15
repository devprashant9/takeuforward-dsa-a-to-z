import java.util.Arrays;

public class LongestCommonSubstring {

    public int longestCommonSubstr(String str1, String str2) {
        return recursive(str1, str2, str1.length(), str2.length(), 0);
    }

    private int recursive(String s1, String s2, int i, int j, int count) {
        if (i == 0 || j == 0) {
            return count;
        }

        int match = count;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            match = recursive(s1, s2, i - 1, j - 1, count + 1);
        }

        int skipS1 = recursive(s1, s2, i - 1, j, 0);
        int skipS2 = recursive(s1, s2, i, j - 1, 0);

        return Math.max(match, Math.max(skipS1, skipS2));
    }

    private int dpSolution(String s1, String s2, int i, int j, int[][] dp) {

        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + dpSolution(s1, s2, i - 1, j - 1, dp);
        }

        return dp[i][j] = 0;
    }

    public int tabulation(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);

                } else {

                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public int tabulationOptimized(String str1, String str2) {

    int n = str1.length();
    int m = str2.length();

    int[] prev = new int[m + 1];
    int[] curr = new int[m + 1];

    int ans = 0;

    for (int i = 1; i <= n; i++) {

    for (int j = 1; j <= m; j++) {

    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

    curr[j] = 1 + prev[j - 1];
    ans = Math.max(ans, curr[j]);

    } else {

    curr[j] = 0;
    }
    }

    prev = curr;
    curr = new int[m + 1];
    }

    return ans;
    }
}