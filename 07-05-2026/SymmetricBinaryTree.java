import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {

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
        Node rootNode = new Node(10);
        root = rootNode;

        Node one = new Node(20);
        Node two = new Node(30);
        root.left = one;
        root.right = two;

        Node three = new Node(40);
        Node four = new Node(50);
        Node five = new Node(60);
        Node nine = new Node(100);

        one.left = three;
        one.right = four;

        two.left = five;
        two.right = nine;

        Node six = new Node(70);
        Node seven = new Node(80);
        Node eight = new Node(90);

        three.left = six;
        three.right = seven;

        four.left = eight;

        return root;
    }

    // Symmetric Brute Using Level Order
    public static boolean isSymmetricBrute(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            Node a = q.remove();
            Node b = q.remove();

            if (a == null && b == null) {
                continue;
            }

            if (a == null || b == null) {
                return false;
            }

            if (a.data != b.data) {
                return false;
            }

            q.add(a.left);
            q.add(b.right);

            q.add(a.right);
            q.add(b.left);
        }

        return true;
    }

    // Symmetric Optimal
    public static boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }

    // optimal helper
    public static boolean isMirror(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        return a.data == b.data &&
                isMirror(a.left, b.right) &&
                isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // symmetric brute
        isSymmetricBrute(root);

        // symmetric optimal
        System.out.println(isSymmetric(root));
    }

}