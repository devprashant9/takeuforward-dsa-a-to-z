public class LongestRepeatingCharacter {

    public static int longestRepeatingCharacter(String s, int k) {
        int sLen = s.length();
        int maxOccurrences = 0, substringLength = 0, replacementNeeded = 0;
        int maxLen = 0;
        int i = 0, j = 0;
        int[] freq = new int[26];

        while (j < sLen) {
            freq[s.charAt(j) - 'A']++;

            maxOccurrences = Math.max(maxOccurrences, freq[s.charAt(j) - 'A']);
            substringLength = j - i + 1;
            replacementNeeded = substringLength - maxOccurrences;

            if (replacementNeeded > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        int k = 2;
        System.out.println("Longest Repeating Character is: " + longestRepeatingCharacter(s, k));
    }
}