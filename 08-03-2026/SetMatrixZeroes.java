import java.util.Arrays;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        System.out.println("After Converting to Zero:");
        setZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}