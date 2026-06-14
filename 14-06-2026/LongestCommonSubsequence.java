public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ade";

        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static int recursive(String s1, int i, String s2, int j) {
        if(i == s1.length() || j == s2.length()) return 0;

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        int same = Integer.MIN_VALUE;
        int different = Integer.MIN_VALUE;

        if(ch1 == ch2) {
            same = 1 + recursive(s1, i + 1, s2, j + 1);
        } else {
            int pickS1 = recursive(s1, i + 1, s2, j);
            int pickS2 = recursive(s1, i, s2, j + 1);
            different = Math.max(pickS1, pickS2);
        }

        return Math.max(same, different);
    }
}