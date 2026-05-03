import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

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

    // Pre Order Traversal Iterative TC o(n) SC O(n)
    public static List<Integer> preOrderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        while (root != null || !st.isEmpty()) {

            // pop the right node
            if (root == null) {
                root = st.pop();
            }

            // process root
            ans.add(root.data);

            // store right
            if (root.right != null) {
                st.push(root.right);
            }

            // go to left
            root = root.left;
        }

        return ans;
    }

    // Pre Order Traversal Recursive TC O(n) SC o(n)
    public static List<Integer> preOrderRecursive(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Iterative Solution Answer
        System.out.println(preOrderIterative(root));

        // Recursive SOlution Answer
        System.out.println(preOrderRecursive(root));
    }

}
