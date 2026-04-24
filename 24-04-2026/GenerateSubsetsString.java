import java.util.ArrayList;
import java.util.List;

public class GenerateSubsetsString {

    // Solution 1: return type void, index absent
    public static void generateSubset(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0);
        String rem = s.substring(1);

        generateSubset(rem, ans + ch);
        generateSubset(rem, ans);
    }

    // Solution 2: return type void, index present
    public static void generateSubset(String s, String ans, int start) {
        if (start == s.length()) {
            if (ans == "") {
                System.out.println('X');
            }
            System.out.println(ans);
            return;
        }

        generateSubset(s, ans + s.charAt(start), start + 1);
        generateSubset(s, ans, start + 1);
    }

    // Solution 3: return type List<String>, index absent
    public static List<String> generateSubset(String s, String ans, List<String> store) {
        if (s.length() == 0) {
            store.add(ans);
            return store;
        }

        char ch = s.charAt(0);
        String rem = s.substring(1);

        generateSubset(rem, ans + ch, store);
        generateSubset(rem, ans, store);

        return store;
    }

    // Solution 4: return type List<String>, index & ans absent, Functional
    // Recursion
    public static List<String> generateSubset(String s) {
        if (s.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = s.charAt(0);
        String rem = s.substring(1);

        List<String> smallAns = generateSubset(rem);

        List<String> ans = new ArrayList<>();

        // Pick Choices
        for (String temp : smallAns) {
            ans.add(temp); // Pick
            ans.add(ch + temp); // Not Pick
        }

        return ans;
    }

    // Solution 5: Iterative Solution
    public static List<String> iterativeSubset(String s) {
        List<String> ans = new ArrayList<>();
        int sLen = s.length();
        ans.add("");

        for (int i = 0; i < sLen; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                ans.add(ans.get(j) + s.charAt(i));
            }
        }
        return ans;
    }

    // Solution 6: Using BitMasking
    public static List<String> subsetsBitmask(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    // Solution 7:Lexicographic / Combination Style 4 Sorted Input
    public static void subsetsLexi(String s, int start, String ans, List<String> res) {
        res.add(ans);

        for (int i = start; i < s.length(); i++) {
            subsetsLexi(s, i + 1, ans + s.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateSubset("abc"));
        System.out.println(iterativeSubset("abc"));

        
        List<String> res = new ArrayList<>();
        subsetsLexi("abc", 0, "", res);
        System.out.println(res);
    }
}