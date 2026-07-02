
public class ImplementTrieII {

    static class Node {
        private Node[] links;
        private int endsWith;
        private int countPrefix;

        Node() {
            links = new Node[26];
            endsWith = 0;
            countPrefix = 0;
        }

        private void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        private Node get(char ch) {
            return links[ch - 'a'];
        }

        private boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        private int getEnd() {
            return endsWith;
        }

        private void increaseEnd() {
            endsWith++;
        }

        private void decreaseEnd() {
            endsWith--;
        }

        private int getPrefixCount() {
            return countPrefix;
        }

        private void increasePrefixCount() {
            countPrefix++;
        }

        private void decreasePrefixCount() {
            countPrefix--;
        }
    }

    private Node root;

    public ImplementTrieII() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        int sLen = word.length();

        for (int i = 0; i < sLen; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
            node.increasePrefixCount();
        }

        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        int sLen = word.length();

        for (int i = 0; i < sLen; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }

        return node.getEnd();
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        int sLen = prefix.length();

        for (int i = 0; i < sLen; i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        return node.getPrefixCount();
    }

    public void erase(String word) {
        if (countWordsEqualTo(word) == 0)
            return;

        Node node = root;
        int sLen = word.length();

        for (int i = 0; i < sLen; i++) {
            char ch = word.charAt(i);
            node = node.get(ch);
            node.decreasePrefixCount();

        }

        node.decreaseEnd();
    }
}