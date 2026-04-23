public class CalculatePower {

    public static int calculatePower(int x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return helper(x, N);
    }

    public static int helper(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int res = helper(x, n / 2);
        res = res * res;

        if (n % 2 == 0) {
            return res;
        } else {
            return x * res;
        }
    }

    public static void main(String[] args) {
        System.out.println("Calculate Power 2^10: " + calculatePower(2, 10));
    }
}