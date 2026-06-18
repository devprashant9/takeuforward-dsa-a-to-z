public class EditDistance {

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "azced";

        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static int recursive(String s1, int i, String s2, int j) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = recursive(s1, i + 1, s2, j + 1);
        } else {
            int insert = recursive(s1, i, s2, j + 1);
            int delete = recursive(s1, i + 1, s2, j);
            int replace = recursive(s1, i + 1, s2, j + 1);
            ans = 1 + Math.min(insert, Math.min(delete, replace));
        }

        return ans;
    }
}