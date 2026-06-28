public class CheckithBit {

    public static void main(String[] args) {
        int n = 5;
        int i = 0;

        System.out.println(checkIthBit1(n, i));
        System.out.println(checkIthBit2(n, i));
        System.out.println(checkIthBit3(n, i));
        System.out.println(checkIthBit4(n, i));
    }

    // Method 1: shift + mask
    private static boolean checkIthBit1(int n, int i) {
        return ((n >> i) & 1) == 1;
    }

    // Method 2: direct mask
    private static boolean checkIthBit2(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // Method 3: your shift-to-end idea
    private static boolean checkIthBit3(int n, int i) {
        while (i != 0) {
            n >>= 1;
            i--;
        }
        return (n & 1) == 1;
    }

    // Method 4: same as mask (clean form)
    private static boolean checkIthBit4(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}