class Node {
    private Node[] links;
    private boolean flag;

    Node() {
        links = new Node[26];
        flag = false;
    }

    void put(char ch, Node n) {
        links[ch - 'a'] = n;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

}

public class ImplementTrie {
    private Node root;

    ImplementTrie() {
        root = new Node();
    }

    void insertWord(String word) {
        Node node = root;

        int sLen = word.length();
        for (int i = 0; i < sLen; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean searchWord(String word) {
        Node node = root;

        int sLen = word.length();
        for (int i = 0; i < sLen; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    boolean startsWithWord(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }

        return true;
    }
}