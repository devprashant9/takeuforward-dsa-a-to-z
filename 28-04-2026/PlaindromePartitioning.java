import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {

    public static void plaindromePartitioning(String s) {
        helper(s, 0, new ArrayList<>());
    }

    public static void helper(String s, int i, List<String> ans) {

        if (i == s.length()) {
            System.out.println(ans);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            boolean isValid = isPalindromeValid(s, i, j);
            if (isValid) {
                ans.add(s.substring(i, j + 1));
                helper(s, j + 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static boolean isPalindromeValid(String s, int start, int end) {
        if (s.length() == 1) {
            return true;
        }

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        plaindromePartitioning(s);
    }
}