class RotateMatrix90Degrees {

    public static void rotateMatrix(int[][] matrix) {
        transposeMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            reverseArry(matrix[i], 0, matrix[i].length - 1);
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

    public static void reverseArry(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}