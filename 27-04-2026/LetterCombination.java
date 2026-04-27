import java.util.HashMap;
import java.util.Map;

public class LetterCombination {

    public static void generateLetterCombination(String s) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(3, "def");
        mp.put(4, "ghi");
        helper(s, 0, mp, "");
    }

    public static void helper(String s, int i, Map<Integer, String> mp, String ans) {
        if (i == s.length()) {
            System.out.println(ans);
            return;
        }

        String letters = mp.get(s.charAt(i) - '0');
        for (int j = 0; j < letters.length(); j++) {
            ans = ans + letters.charAt(j);
            helper(s, i + 1, mp, ans);
            ans = ans.substring(0, ans.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "34";
        generateLetterCombination(s);
    }
}