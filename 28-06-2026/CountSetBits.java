/**
 * CountSetBits
 */
public class CountSetBits {

    public static void main(String[] args) {
        int n = 17; // 1 0 0 0 1

        System.out.println(countSetBits(n));
        System.out.println(brianKernighansAlgo(n));
        System.out.println(inbuiltFastest(n));
    }

    private static int countSetBits(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n = n >> 1;
        }
        return cnt;
    }

    private static int brianKernighansAlgo(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    private static int inbuiltFastest(int n) {
        return Integer.bitCount(n);
    }
}