public class SpiralMatrixPrint {

    public static void printSpiralMatrix(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.println(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.println(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.println(matrix[i][left]);
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 10, 20, 30, 40 },
                { 50, 60, 70, 80 },
                { 90, 10, 20, 30 },
                { 40, 50, 60, 70 }
        };
        printSpiralMatrix(nums);
    }
}