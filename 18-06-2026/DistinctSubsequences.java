public class DistinctSubsequences {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        String s1 = "axbxax";
        String s2 = "axa";

        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static int recursive(String s1, int i, String s2, int j) {
        if (i == s1.length() && j != s2.length())
            return 0;
        if (i != s1.length() && j == s2.length())
            return 1;
        if (i == s1.length() && j == s2.length())
            return 1;

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            int skipBoth = recursive(s1, i + 1, s2, j + 1);
            int skipS1 = recursive(s1, i + 1, s2, j);
            ans = (skipBoth + skipS1) % MOD;
        } else {
            ans = recursive(s1, i + 1, s2, j);
        }

        return ans;
    }
}