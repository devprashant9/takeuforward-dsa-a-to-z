public class CitySmallestNeighbours {
    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {

        int INF = (int) 1e9;

        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // Fill edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] == INF || dist[via][j] == INF) {
                        continue;
                    }

                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][via] + dist[via][j]);
                }
            }
        }

        int city = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Tie -> larger index city
            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }
    
}