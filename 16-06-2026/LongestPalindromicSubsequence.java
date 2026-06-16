public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s1 = "eeeme";
        String s2 = new StringBuilder(s1).reverse().toString();

        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static int recursive(String s1, int i, String s2, int j) {
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }

        int match = 0;
        int unmatch = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            match = 1 + recursive(s1, i + 1, s2, j + 1);
        } else {
            int skipS1 = recursive(s1, i + 1, s2, j);
            int skipS2 = recursive(s1, i, s2, j + 1);
            unmatch = Math.max(skipS1, skipS2);
        }
        return Math.max(match, unmatch);
    }
}