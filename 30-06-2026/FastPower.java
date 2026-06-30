/**
 * FastPower
 */
public class FastPower {

    public static void main(String[] args) {
        int x = 2;
        int n = 10;

        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        System.out.println(fastPower(x, N));
    }

    private static double fastPower(long x, long n) {
        if (n == 0)
            return 1;

        double res = fastPower(x, n / 2);
        res = res * res;

        if ((n & 1) == 0)
            return res;
        else
            return x * res;
    }
}