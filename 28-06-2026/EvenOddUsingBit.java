/**
 * EvenOddUsingBit
 */
public class EvenOddUsingBit {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(evenOdd(n));
        System.out.println(evenOddUsingBits(n));
    }

    private static String evenOdd(int n) {
        return n % 2 == 0 ? "Even" : "Odd";
    }

    private static String evenOddUsingBits(int n) {
        return ((n & 1) == 0) ? "Even" : "Odd";
    }
}