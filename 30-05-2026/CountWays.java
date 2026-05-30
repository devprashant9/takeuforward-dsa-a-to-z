import java.util.*;

class CountWays {
    public int countPaths(int n, List<List<Integer>> roads) {
        int MOD = 1_000_000_007;

        @SuppressWarnings("unchecked")
        List<long[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int time = road.get(2);

            graph[u].add(new long[] { v, time });
            graph[v].add(new long[] { u, time });
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[] { 0, 0 }); // {node, distance}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node])
                continue;

            for (long[] nei : graph[node]) {
                int next = (int) nei[0];
                long wt = nei[1];

                long newDist = d + wt;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[] { next, newDist });
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}