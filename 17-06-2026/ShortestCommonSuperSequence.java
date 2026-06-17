public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String s1 = "mno";
        String s2 = "nop";
        System.out.println(recursive(s1, 0, s2, 0));
    }

    private static String recursive(String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            return s2.substring(j);
        }

        if (j == s2.length()) {
            return s1.substring(i);
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + recursive(s1, i + 1, s2, j + 1);
        }

        String option1 = s1.charAt(i) + recursive(s1, i + 1, s2, j);
        String option2 = s2.charAt(j) + recursive(s1, i, s2, j + 1);

        return option1.length() <= option2.length() ? option1 : option2;
    }
}