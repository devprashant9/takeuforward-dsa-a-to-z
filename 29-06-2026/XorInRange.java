/**
 * XorInRange
 */
public class XorInRange {

    public static void main(String[] args) {
        int l = 5;
        int r = 15;
        System.out.println(xorInRange(l, r));
    }

    private static int xorInRange(int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans ^= i;
        }
        return ans;
    }
}