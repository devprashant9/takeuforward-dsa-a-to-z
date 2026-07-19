public class EvaluateExpression {

    public static void main(String[] args) {

        String s = "T|T&F^T";
        System.out.println(countWays(s, 0, s.length() - 1, 1));
    }

    static int countWays(String s, int i, int j, int isTrue) {

        if (i > j)
            return 0;

        if (i == j) {

            if (isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        int ways = 0;

        // operators are at odd indexes
        for (int k = i + 1; k <= j - 1; k += 2) {

            int LT = countWays(s, i, k - 1, 1);
            int LF = countWays(s, i, k - 1, 0);

            int RT = countWays(s, k + 1, j, 1);
            int RF = countWays(s, k + 1, j, 0);

            char op = s.charAt(k);

            if (op == '&') {

                if (isTrue == 1)
                    ways += LT * RT;
                else
                    ways += LT * RF + LF * RT + LF * RF;
            }

            else if (op == '|') {

                if (isTrue == 1)
                    ways += LT * RT + LT * RF + LF * RT;
                else
                    ways += LF * RF;
            }

            else if (op == '^') {

                if (isTrue == 1)
                    ways += LT * RF + LF * RT;
                else
                    ways += LT * RT + LF * RF;
            }
        }

        return ways;
    }
}