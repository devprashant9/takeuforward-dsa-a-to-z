public class NthRoot {

    public static int nthRoot(int M, int N) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = (long) Math.pow(mid, N);

            if (val == M) {
                return mid;
            } else if (val > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int M = 69;
        int N = 4;
        System.out.println("Nth Root of M is: " + nthRoot(M, N));
    }
}