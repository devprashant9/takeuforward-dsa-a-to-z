import java.util.*;

class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    break; // Only first different character matters
                }
            }
        }

        // Calculate indegree
        int[] indegree = new int[K];

        for (int i = 0; i < K; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char) (node + 'a'));

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        return ans.toString();
    }
}