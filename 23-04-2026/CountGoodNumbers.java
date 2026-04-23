public class CountGoodNumbers {

    static final int MOD = 1_000_000_007;

    public static long countGoodNumbers(long n) {

        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = power(5, evenPos);
        long oddWays = power(4, oddPos);

        return (evenWays * oddWays) % MOD;
    }

    // fast exponentiation: base^pow % MOD
    public static long power(long base, long pow) {

        long result = 1;
        base %= MOD;

        while (pow > 0) {

            if ((pow & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            pow >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        long n = 5;
        System.out.println(countGoodNumbers(n)); // 2000
    }
}