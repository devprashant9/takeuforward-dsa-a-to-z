public class PowerOf2 {
    
    public static void main(String[] args) {
        int n = 8;

        System.out.println("Power of 2: " +isPowerOf2(n));
    }

    private static boolean isPowerOf2(int n) {
        return((n & (n - 1)) == 0);
    }
}
