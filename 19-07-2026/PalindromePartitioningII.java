
public class PalindromePartitioningII {

    public static void main(String[] args) {
        String s = "abaaba";

        System.out.println(minCut(s));
    }

    static int minCut(String s) {
        return solve(0, s) - 1;
    }

    static int solve(int i, String s) {

        if (i == s.length())
            return 0;

        int min = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {

            if (isPalindrome(s, i, j)) {

                int cost = 1 + solve(j + 1, s);

                min = Math.min(min, cost);
            }
        }

        return min;
    }

    static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}