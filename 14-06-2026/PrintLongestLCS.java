public class PrintLongestLCS {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ade";

        print(s1, 0, s2, 0, new StringBuilder());
    }

    private static void print(String s1, int i, String s2, int j, StringBuilder sb) {

        if (i == s1.length() || j == s2.length()) {
            System.out.println(sb.toString());
            return;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            print(s1, i + 1, s2, j + 1, new StringBuilder(sb).append(s1.charAt(i)));
        } else {
            // compare both recursive possibilities
            int skipS1 = lcsLen(s1, i + 1, s2, j);
            int skipS2 = lcsLen(s1, i, s2, j + 1);

            if (skipS1 > skipS2) {
                print(s1, i + 1, s2, j, new StringBuilder(sb));
            } else {
                print(s1, i, s2, j + 1, new StringBuilder(sb));
            }
        }
    }

    private static int lcsLen(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcsLen(s1, i + 1, s2, j + 1);
        }

        return Math.max(lcsLen(s1, i + 1, s2, j), lcsLen(s1, i, s2, j + 1));
    }
}