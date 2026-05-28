import java.util.*;

public class CheapestFlight {

    public static int cheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        dist[src] = 0;

        int stops = 0;

        while (!q.isEmpty() && stops <= K) {
            int size = q.size();

            int[] tempDist = dist.clone();

            while (size-- > 0) {
                int[] curr = q.poll();

                int node = curr[0];
                int cost = curr[1];

                for (int[] nei : adj.get(node)) {
                    int next = nei[0];
                    int price = nei[1];

                    if (cost + price < tempDist[next]) {
                        tempDist[next] = cost + price;
                        q.offer(new int[] { next, cost + price });
                    }
                }
            }

            dist = tempDist;
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}