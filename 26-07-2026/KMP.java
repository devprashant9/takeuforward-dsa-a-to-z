public class KMP {

    // Computes the LPS (Longest Prefix Suffix) array
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Returns the first occurrence of pattern in text
    public static int search(String text, String pattern) {
        if (pattern.isEmpty())
            return 0;

        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        int i = 0; // text pointer
        int j = 0; // pattern pointer

        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j; // Match found
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";

        System.out.println(search(text, pattern)); // 10
    }
}