import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int countFreshOranges(int[][] graph, int m, int n) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public Queue<Pair> findStart(int[][] graph, int m, int n) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        return q;
    }

    public boolean checkBound(int[][] graph, int m, int n) {
        if (m < 0 || m >= graph.length) {
            return false;
        }

        if (n < 0 || n >= graph[0].length) {
            return false;
        }

        return true;
    }

    public int bfs(int[][] graph, int m, int n, int fresh) {
        int time = 0;
        Queue<Pair> q = findStart(graph, m, n);

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pair p = q.remove();
                int r = p.key;
                int c = p.value;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (checkBound(graph, nr, nc) && graph[nr][nc] == 1) {
                        graph[nr][nc] = 2;
                        q.add(new Pair(nr, nc));
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

    public int rottenOranges(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        int fresh = countFreshOranges(graph, m, n);
        return bfs(graph, m, n, fresh);
    }
}