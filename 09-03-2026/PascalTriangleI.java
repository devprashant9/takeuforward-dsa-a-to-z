public class PascalTriangleI {

    public static int pascalTriangleValue(int r, int c) {
        r -= 1;
        c -= 1;
        int ans = 1;
        for (int i = 0; i < c; i++) {
            ans *= (r - i);
            ans /= (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int r = 5;
        int c = 4;
        System.out.println("Pascal Triangle Value at Given Row & Col is: " + pascalTriangleValue(r, c));
    }
}