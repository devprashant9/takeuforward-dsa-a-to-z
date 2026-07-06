import java.util.*;

class MaximumXorWithElements {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.child[bit] == null)
                    node.child[bit] = new TrieNode();

                node = node.child[bit];
            }
        }

        int getMaxXor(int num) {
            TrieNode node = root;
            int ans = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.child[1 - bit] != null) {
                    ans |= (1 << i);
                    node = node.child[1 - bit];
                } else {
                    node = node.child[bit];
                }
            }

            return ans;
        }
    }

    public List<Integer> maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;

        int[][] offlineQueries = new int[q][3];

        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][0]; // xi
            offlineQueries[i][1] = queries[i][1]; // mi
            offlineQueries[i][2] = i; // original index
        }

        Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();

        Integer[] ans = new Integer[q];

        int idx = 0;

        for (int[] query : offlineQueries) {

            int x = query[0];
            int m = query[1];
            int originalIndex = query[2];

            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx]);
                idx++;
            }

            if (idx == 0) {
                ans[originalIndex] = -1;
            } else {
                ans[originalIndex] = trie.getMaxXor(x);
            }
        }

        return Arrays.asList(ans);
    }
}