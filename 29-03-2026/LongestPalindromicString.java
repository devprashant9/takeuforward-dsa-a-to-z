public class LongestPalindromicString {

    public static String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < sLen; i++) {
            int[] odd = expandAroundCenter(s, i, i);
            int[] even = expandAroundCenter(s, i, i + 1);

            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }

            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }
        return s.substring(start, end + 1);
    }

    public static int[] expandAroundCenter(String s, int left, int right) {
        int sLen = s.length();
        while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[] { left + 1, right - 1 };
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindromic Substring is: " + longestPalindrome(s));
    }
}
