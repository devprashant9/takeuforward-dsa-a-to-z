
public class MinWindowSubstring {

    public static String minWindowSubstring(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int[] freq = new int[128];

        for (int k = 0; k < tLen; k++) {
            freq[t.charAt(k)]++;
        }

        int i = 0, j = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;

        while (j < sLen) {

            // include current char of s
            if (freq[s.charAt(j)] > 0) {
                cnt++;
            }
            freq[s.charAt(j)]--;

            // shrink window
            while (cnt == tLen) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                freq[s.charAt(i)]++;
                if (freq[s.charAt(i)] > 0) {
                    cnt--;
                }
                i++;
            }

            j++;
        }

        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring is: " + minWindowSubstring(s, t));
    }
}