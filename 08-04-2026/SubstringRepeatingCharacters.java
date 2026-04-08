public class SubstringRepeatingCharacters {

    public static int longestSubstring(String s) {
        int sLen = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        int[] freq = new int[26];

        while (j < sLen) {
            freq[s.charAt(j) - 'a']++;

            while (freq[s.charAt(j) - 'a'] > 1) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcddabac";
        System.out.println("Longest Substring Without Repeating Character is: " + longestSubstring(s));
    }
}