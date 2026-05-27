import java.util.*;

public class MinimumEffort {

    static class Pair {
        int row, col, effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffort(List<List<Integer>> heights) {

        int n = heights.size();
        int m = heights.get(0).size();

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int r = cur.row;
            int c = cur.col;
            int effort = cur.effort;

            if (r == n - 1 && c == m - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {

                    int currentHeight = heights.get(r).get(c);
                    int nextHeight = heights.get(nr).get(nc);

                    int newEffort = Math.max(
                            effort,
                            Math.abs(currentHeight - nextHeight));

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}