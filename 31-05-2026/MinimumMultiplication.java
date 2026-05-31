import java.util.*;

class MinimumMultiplication {
    public int minimumMultiplications(int[] arr, int start, int end) {
        int MOD = 100000;

        int[] dist = new int[MOD];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == end) {
                return dist[curr];
            }

            for (int num : arr) {
                int next = (int) (((long) curr * num) % MOD);

                if (dist[curr] + 1 < dist[next]) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }

        return -1;
    }
}