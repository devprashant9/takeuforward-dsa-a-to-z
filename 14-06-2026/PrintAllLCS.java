public class PrintAllLCS {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ade";

        printLCS(s1, 0, s2, 0, new StringBuilder());
    }

    private static void printLCS(String s1, int i, String s2, int j, StringBuilder sb) {
        if (i == s1.length() || j == s2.length()) {
            System.out.println(sb.toString());
            return;
        }

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) {
            printLCS(s1, i + 1, s2, j + 1, sb.append(ch1));
        } else {
            printLCS(s1, i + 1, s2, j, new StringBuilder(sb));
            printLCS(s1, i, s2, j + 1, new StringBuilder(sb));
        }
    }
}