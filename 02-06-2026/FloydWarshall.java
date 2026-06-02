public class FloydWarshall {

    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        // Convert -1 (no edge) to a large value
        int INF = (int) 1e9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = INF;
                }
            }
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != INF && matrix[k][j] != INF) {
                        matrix[i][j] = Math.min(matrix[i][j],
                                matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        // Convert back INF -> -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}