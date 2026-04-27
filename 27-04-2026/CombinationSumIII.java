import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void generateCombination(int k, int n) {
        helper(n, k, 1, new ArrayList<>());
    }

    public static void helper(int n, int k, int last, List<Integer> ans) {
        if (n == 0 && ans.size() == k) {
            System.out.println(ans);
            return;
        }

        if (n <= 0 || ans.size() > k) {
            return;
        }

        for (int i = last; i <= 9; i++) {
            if (i <= n) {
                ans.add(i);
                helper(n - i, k, i + 1, ans);
                ans.remove(ans.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        generateCombination(k, n);
    }
}