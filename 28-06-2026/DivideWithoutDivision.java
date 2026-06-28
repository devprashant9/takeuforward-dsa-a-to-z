/**
 * DividwWithoutDivision
 */
public class DivideWithoutDivision {

    public static void main(String[] args) {
        int divisor = 3;
        int dividend = 10;

        System.out.println(divideBrute(dividend, divisor));
        System.out.println(divideOptimal(dividend, divisor));
    }

    private static int divideBrute(int dividend, int divisor) {
        int sum = 0;
        int cnt = 0;
        while (sum + divisor <= dividend) {
            sum += divisor;
            cnt++;
        }
        return cnt;
    }

    private static int divideOptimal(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0) == (divisor >= 0);

        long num = Math.abs((long) dividend);
        long den = Math.abs((long) divisor);

        long ans = 0;

        while (num >= den) {
            long temp = den;
            long multiple = 1;

            while (num >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            num -= temp;
            ans += multiple;
        }

        ans = sign ? ans : -ans;

        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) ans;
    }
}