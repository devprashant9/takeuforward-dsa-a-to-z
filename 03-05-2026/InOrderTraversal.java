import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

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
        root.left = one;

        Node two = new Node(30);
        root.right = two;

        Node three = new Node(40);
        root.left.left = three;

        Node four = new Node(50);
        root.left.right = four;

        Node five = new Node(60);
        root.right.right = five;

        Node six = new Node(70);
        root.left.left.left = six;

        Node seven = new Node(80);
        root.left.right.left = seven;

        Node eight = new Node(90);
        root.left.right.right = eight;

        Node nine = new Node(100);
        root.right.right.left = nine;

        return root;
    }

    // InOrder Traversal Iterative
    public static List<Integer> inOrderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        while (root != null || !st.isEmpty()) {

            // smallest subtree -> process left root and go right
            if (root == null) {
                root = st.pop();
                ans.add(root.data);
                root = root.right;
            }

            // push current node
            if (root != null) {
                st.push(root);
            }

            // go left
            if (root != null) {
                root = root.left;
            }
        }
        return ans;
    }

    // InOrder Recursive
    public static List<Integer> inOrderRecursive(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        helper(root.left, ans);
        ans.add(root.data);
        helper(root.right, ans);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Iterative Solution Answer
        System.out.println(inOrderIterative(root));

        // Recursive SOlution Answer
        System.out.println(inOrderRecursive(root));
    }

}