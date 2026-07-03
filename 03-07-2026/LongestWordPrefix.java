import java.util.List;

/**
 * LongestWordPrefix
 */
public class LongestWordPrefix {

    static class Node {
        Node[] links = new Node[26];
        boolean isEnd;

        boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            isEnd = true;
        }

        boolean isEnd() {
            return isEnd;
        }
    }

    static class Trie {
        Node root = new Node();

        void insert(String word) {
            Node node = root;

            for (char ch : word.toCharArray()) {
                if (!node.contains(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }

            node.setEnd();
        }

        boolean checkIfAllPrefixesExist(String word) {
            Node node = root;

            for (char ch : word.toCharArray()) {
                node = node.get(ch);

                if (node == null || !node.isEnd()) {
                    return false;
                }
            }

            return true;
        }
    }

    public String completeString(List<String> nums) {

        Trie trie = new Trie();

        for (String word : nums) {
            trie.insert(word);
        }

        String ans = "";

        for (String word : nums) {

            if (trie.checkIfAllPrefixesExist(word)) {

                if (word.length() > ans.length()) {
                    ans = word;
                } else if (word.length() == ans.length()
                        && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans.isEmpty() ? "None" : ans;
    }
}