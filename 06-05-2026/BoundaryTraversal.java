import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {

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

    // Boundary Traversal 3 Different Traversal Problem in below order respectively
    // Left Boundary
    // leaves
    // Right Boundary
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        // root should be included only once
        ans.add(root.data);

        // left boundary excluding root
        leftBoundary(root.left, ans);

        // leaf nodes in left subtree and right subtree of root
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);

        // right boundary (reverse)
        List<Integer> right = new ArrayList<>();
        rightBoundary(root.right, right);
        Collections.reverse(right);
        ans.addAll(right);

        return ans;
    }

    public static void leftBoundary(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.data);

        if (root.left != null) {
            leftBoundary(root.left, ans);
        } else {
            leftBoundary(root.right, ans);
        }
    }

    public static void leafNodes(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    public static void rightBoundary(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.data);

        if (root.right != null) {
            rightBoundary(root.right, ans);
        } else {
            rightBoundary(root.left, ans);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Boundary Traversal Optimized
        System.out.println(boundaryTraversal(root));

    }

}