
public class ReverseWordsInGivenString {

    public static String reverseWordsInGivenString(String s) {
        StringBuilder sb = removeExtraSpaces(s); // "the sky is blue"
        int n = sb.length();

        reverseString(sb, 0, n - 1); // "eulb si yks eht"
        reverseEachWord(sb); // "blue is sky the"

        return sb.toString();
    }

    public static StringBuilder removeExtraSpaces(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = 0;
        int j = 0;

        while (i < n) {
            // skip initial spaces
            while (i < n && sb.charAt(i) == ' ') {
                i++;
            }
            // shift each element to right
            while (i < n && sb.charAt(i) != ' ') {
                sb.setCharAt(j++, sb.charAt(i++));
            }
            // remove spaces between words. we need to write it because of the sequential
            // flow
            while (i < n && sb.charAt(i) == ' ') {
                i++;
            }
            // add space between words if more words exists
            if (i < n) {
                sb.setCharAt(j++, ' ');
            }
        }
        return new StringBuilder(sb.substring(0, j));
    }

    public static void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;

        for (int end = 0; end <= n; end++) {
            if (end == n || sb.charAt(end) == ' ') {
                reverseString(sb, start, end - 1);
                start = end + 1;
            }
        }
    }

    public static void main(String[] args) {
        String s = "   the sky   is  blue   ";
        System.out.println("The Modified String is: " + reverseWordsInGivenString(s));
        System.out.println(reverseWordsInGivenString(s).length());
    }
}
