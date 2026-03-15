public class PascalTriangle {

    public static int nthNumberInPascalTriangle(int r, int c) {
        r -= 1;
        c -= 1;
        int num = 1;
        for (int i = 0; i < c; i++) {
            num *= r - i;
            num /= i + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("Nth Pascal Number For Given Row and Colum: 4, 5 is: " + nthNumberInPascalTriangle(5, 4));
    }
}