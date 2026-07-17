import java.util.*;

class AccountMerge {

    static class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;

            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        // email -> account index
        HashMap<String, Integer> emailMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, i);
                } else {
                    ds.unionBySize(i, emailMap.get(email));
                }
            }
        }

        List<String>[] mergedEmails = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedEmails[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : emailMap.entrySet()) {

            String email = entry.getKey();
            int accountIndex = entry.getValue();

            int parent = ds.findParent(accountIndex);

            mergedEmails[parent].add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedEmails[i].isEmpty())
                continue;

            Collections.sort(mergedEmails[i]);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0)); // account name
            temp.addAll(mergedEmails[i]);

            ans.add(temp);
        }

        return ans;
    }
}