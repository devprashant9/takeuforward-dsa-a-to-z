import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void generateValidParenthses(int n) {
        System.out.println(helper(n, 0, 0, "", new ArrayList<>()));
    }

    public static List<String> helper(int n, int open, int close, String ans, List<String> store) {
        if (ans.length() == 2 * n) {
            store.add(ans);
            return store;
        }

        if (open < n) {
            helper(n, open + 1, close, ans + '(', store);
        }

        if (close < open) {
            helper(n, open, close + 1, ans + ')', store);
        }

        return store;
    }

    public static void main(String[] args) {
        int n = 3;
        generateValidParenthses(n);
    }
}