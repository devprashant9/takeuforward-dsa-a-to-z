import java.util.Arrays;

public class RotateMatrix90Degrees {

    public static void rotateMatrix(int[][] matrix) {
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverseArray(matrix[i], 0, matrix[i].length - 1);
        }
    }

    public static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            swapNumbers(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Matrix Rotated By 90 Degree is: ");
        rotateMatrix(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}