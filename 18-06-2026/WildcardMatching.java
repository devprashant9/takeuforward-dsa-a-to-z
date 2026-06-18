public class WildcardMatching {

    public static void main(String[] args) {
        String s1 = "xaylmz";
        String s2 = "x?y*z";

        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static boolean recursive(String text, int i, String pattern, int j) {

        if (i == text.length() && j == pattern.length())
            return true;

        if (j == pattern.length())
            return false;

        if (i == text.length()) {
            while (j < pattern.length()) {
                if (pattern.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }

        if (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '?') {
            return recursive(text, i + 1, pattern, j + 1);
        }

        if (pattern.charAt(j) == '*') {
            return recursive(text, i, pattern, j + 1) || recursive(text, i + 1, pattern, j);
        }

        return false;
    }
}