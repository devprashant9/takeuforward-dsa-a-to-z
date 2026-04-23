public class MyAtoi {

    /*
     * -------------------------------------------------
     * REAL LEFT → RIGHT RECURSIVE ATOI (Correct one)
     * -------------------------------------------------
     */
    public static int atoiLeftToRight(String s) {
        return atoiLTRHelper(s, 0, 1, 0, false);
    }

    private static int atoiLTRHelper(String s, int i, int sign, int result, boolean started) {

        if (i >= s.length())
            return sign * result;

        char ch = s.charAt(i);

        // skip leading spaces (only before number starts)
        if (!started && ch == ' ')
            return atoiLTRHelper(s, i + 1, sign, result, false);

        // handle sign (only before number starts)
        if (!started && (ch == '+' || ch == '-'))
            return atoiLTRHelper(s, i + 1, ch == '-' ? -1 : 1, result, true);

        // stop when non digit appears after start
        if (!Character.isDigit(ch))
            return sign * result;

        int digit = ch - '0';

        // overflow check BEFORE multiplying
        // MAX/10 will this be true if multiplied by 10 or its already greater
        // MAX/10 == MAX check last digit
        if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7))
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        result = result * 10 + digit;

        return atoiLTRHelper(s, i + 1, sign, result, true);
    }

    /*
     * -------------------------------------------------
     * RIGHT → LEFT RECURSIVE (Educational version)
     * Not fully spec-correct but kept for learning.
     * -------------------------------------------------
     */
    public static int atoiRightToLeft(String s, int i, int sign) {

        if (i >= s.length())
            return 0;

        char ch = s.charAt(i);

        if (ch == ' ')
            return atoiRightToLeft(s, i + 1, sign);

        if (ch == '-')
            return atoiRightToLeft(s, i + 1, -1);

        if (!Character.isDigit(ch))
            return 0;

        int suffix = atoiRightToLeft(s, i + 1, sign);
        int digit = ch - '0';

        long res = sign * (suffix * 10 + digit);

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) res;
    }

    public static void main(String[] args) {
        String s = "   -43256ab 12 bc";

        System.out.println("Input : " + s);
        System.out.println("Left To Right atoi : " + atoiLeftToRight(s));
        System.out.println("Right To Left atoi : " + atoiRightToLeft(s, 0, 1));
    }
}