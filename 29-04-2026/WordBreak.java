import java.util.List;

public class WordBreak {

    public static void wordBreak(String s, int i, String ans, List<String> dict) {
        if (i == s.length()) {
            System.out.println(ans + " ");
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String prefix = s.substring(i, j);

            if (dict.contains(prefix)) {
                wordBreak(s, j, ans + prefix, dict);
            }
        }
    }

    public static void main(String[] args) {
        String s = "takeuforward";
        List<String> wordDict = List.of("take", "forward", "you", "u");
        wordBreak(s, 0, "", wordDict);
    }
}
