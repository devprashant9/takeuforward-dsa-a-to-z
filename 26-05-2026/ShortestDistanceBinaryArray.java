import java.util.*;

public class ShortestDistanceBinaryArray {

    static class Pair {
        int r, c, dist;

        Pair(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;

        int sr = source[0];
        int sc = source[1];

        int dr = destination[0];
        int dc = destination[1];

        // source or destination blocked
        if (grid[sr][sc] == 0 || grid[dr][dc] == 0)
            return -1;

        // same cell
        if (sr == dr && sc == dc)
            return 0;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(sr, sc, 0));
        dist[sr][sc] = 0;

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int r = cur.r;
            int c = cur.c;
            int d = cur.dist;

            for (int i = 0; i < 4; i++) {

                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1 &&
                        d + 1 < dist[nr][nc]) {

                    dist[nr][nc] = d + 1;

                    if (nr == dr && nc == dc)
                        return d + 1;

                    q.offer(new Pair(nr, nc, d + 1));
                }
            }
        }

        return -1;
    }
}