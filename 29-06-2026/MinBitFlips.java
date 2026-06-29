/**
 * MinBitFlips
 */
public class MinBitFlips {

    public static void main(String[] args) {
        int n1 = 7;
        int n2 = 10;

        System.out.println("Number of Bit Flips Needed: " + countFlipBits(n1, n2));
    }

    private static int countFlipBits(int n1, int n2) {
        return countSetBits(n1 ^ n2);
    }

    private static int countSetBits(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
}