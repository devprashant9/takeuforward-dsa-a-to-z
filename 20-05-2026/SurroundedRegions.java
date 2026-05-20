import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    
    class Pair{
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public char[][] fill(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        bfs(mat, m, n);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }

                if(mat[i][j] == '#') {
                    mat[i][j] = 'O';
                }
            }
        }

        return mat;
    }

    public Queue<Pair> markStartingPoint(char[][] graph, int m, int n) {
        Queue<Pair> q = new LinkedList<>();

        // top and bottom row
        int r = m - 1;
        for(int col = 0; col < n; col++) {
            if(graph[0][col] == 'O') {
                graph[0][col] = '#';      // mark safe
                q.add(new Pair(0, col));
            }

            if(graph[r][col] == 'O') {
                graph[r][col] = '#';      // mark safe
                q.add(new Pair(r, col));
            }
        }

        // left and right column
        int c = n - 1;
        for(int row = 0; row < m; row++) {
            if(graph[row][0] == 'O') {
                graph[row][0] = '#';      // mark safe
                q.add(new Pair(row, 0));
            }

            if(graph[row][c] == 'O') {
                graph[row][c] = '#';      // mark safe
                q.add(new Pair(row, c));
            }
        }
        return q;
    }

    public boolean checkBound(char[][] graph, int m, int n) {
        if(m < 0 || m >= graph.length) {
            return false;
        }

        if(n < 0 || n >= graph[0].length) {
            return false;
        }

        return true;
    }

    public void bfs(char[][] graph, int m, int n) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<Pair> q = markStartingPoint(graph, m, n);

        while(!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(checkBound(graph, nr, nc) && graph[nr][nc] == 'O') {
                    graph[nr][nc] = '#';
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}