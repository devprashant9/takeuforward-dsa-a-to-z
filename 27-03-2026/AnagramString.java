import java.util.HashMap;
import java.util.Map;

public class AnagramString {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mp = new HashMap<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < sLen; i++) {
            char c = t.charAt(i);
            if (!mp.containsKey(c)) {
                return false;
            }

            int count = mp.get(c) - 1;
            if (count == 0) {
                mp.remove(c);
            } else {
                mp.put(c, count);
            }
        }
        return mp.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Given Strings Are Anagram? " + isAnagram(s, t));
    }
}