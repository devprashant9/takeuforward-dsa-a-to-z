public class PrintNthRowPascalTriangle {

    public static void printTraingle(int n) {
        int ans = 1;
        System.out.println(ans);
        for (int i = 1; i < n; i++) {
            ans *= (n - i);
            ans /= i;
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        printTraingle(n);
    }
}
