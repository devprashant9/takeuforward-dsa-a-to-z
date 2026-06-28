/**
 * SwapUsingBit
 */
public class SwapUsingBit {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        swapUsingBit(a, b);
    }

    private static void swapUsingBit(int a, int b) {
        System.out.println("a = " + a + " " + " b = " + b);

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a = " + a + " " + " b = " + b);
    }
}