public class SqaureRoot {

    public static int squareRoot(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (mid * mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println("Square Root of N is: " + squareRoot(n));
    }
}