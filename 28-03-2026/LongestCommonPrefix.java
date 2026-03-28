public class LongestCommonPrefix {

    public static String longestPrefixMatch(String[] s) {
        StringBuilder sb = new StringBuilder();

        String first = s[0];
        String last = s[s.length - 1];
        int len = Math.min(first.length(), last.length());

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = { "flow", "flower", "flight", "fly" };
        System.out.println("Longest Prefix Match is: " + longestPrefixMatch(s));
    }
}
