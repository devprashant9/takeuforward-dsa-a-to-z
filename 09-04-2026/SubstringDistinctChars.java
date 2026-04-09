import java.util.HashMap;
import java.util.Map;

public class SubstringDistinctChars {

    public static int longestSubstring(String s, int k) {
        int sLen = s.length();
        int i = 0, j = 0;
        int maxLen = 0;

        Map<Character, Integer> mp = new HashMap<>();
        while (j < sLen) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            while (mp.size() > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                i++;
            }

            if (mp.size() <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aababbcaacc";
        int k = 2;
        System.out.println("Longest Substring With K Distinch Charcters is: " + longestSubstring(s, k));
    }
}