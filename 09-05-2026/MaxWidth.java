import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Node root) {
        Node n1 = new Node(10);
        Node n2 = new Node(30);
        Node n3 = new Node(20);
        Node n4 = new Node(50);
        Node n5 = new Node(90);
        Node n6 = new Node(60);
        Node n7 = new Node(70);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n3.right = n5;

        n4.left = n6;

        n5.left = n7;

        root = n1;
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Brute Force
    public static int maxWidth(Node root) {
        int maxWidth = -1;
        int level = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            maxWidth = size;
            level++;
            if (level == 4) {
                break;
            }

            maxWidth = 0;
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                if (curr.left != null) {
                    q.add(curr.left);
                } else {
                    q.add(new Node(-1));
                }

                if (curr.right != null) {
                    q.add(curr.right);
                } else {
                    q.add(new Node(-1));
                }
            }
        }
        return maxWidth;
    }

    // Optimal Solution

    // generic Pair<K, V> class
    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            int leftMostNodeIndex = q.peek().getValue();

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int currId = q.peek().getValue() - leftMostNodeIndex;
                Node curr = q.remove().getKey();

                if (i == 0) {
                    first = currId;
                }

                if (i == size - 1) {
                    last = currId;
                }

                if (curr.left != null) {
                    q.add(new Pair<>(curr.left, currId * 2 + 1));
                }

                if (curr.right != null) {
                    q.add(new Pair<>(curr.right, currId * 2 + 2));
                }

                ans = Math.max(ans, last - first + 1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Brute Force Under Constraints
        System.out.println(maxWidth(root));

        // Optimal Solution
        System.out.println(widthOfBinaryTree(root));
    }
}