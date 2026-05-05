import java.util.ArrayList;
import java.util.List;

public class IdenticalTrees {

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

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    // Brute Force ->
    public static boolean isTreeSameBrute(Node rootA, Node rootB) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        preOrderTraversal(rootA, listA);
        preOrderTraversal(rootB, listB);

        if (listA.size() != listB.size()) {
            return false;
        }

        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i) != listB.get(i)) {
                return false;
            }
        }

        return true;
    }

    // InOrder Traversal & Importantly Also Store null
    public static void preOrderTraversal(Node root, List<Integer> ans) {
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        if (root.left == null || root.right == null) {
            ans.add(null);
            return;
        }

        ans.add(root.data);
        preOrderTraversal(root.left, ans);
        preOrderTraversal(root.right, ans);
    }

    // Optimized Code
    public static boolean isTreeSame(Node rootA, Node rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }

        if (rootA == null || rootB == null) {
            return false;
        }

        if (rootA.data != rootB.data) {
            return false;
        }

        boolean checkLeft = isTreeSame(rootA.left, rootB.left);
        boolean checkRight = isTreeSame(rootA.right, rootB.right);

        return checkLeft && checkRight;
    }

    public static void main(String[] args) {
        Node root1 = null;
        root1 = buildTree(root1);

        Node root2 = null;
        root2 = buildTree(root2);

        // Brute Solution
        System.out.println(isTreeSameBrute(root1, root2));

        // Optimized Solution
        System.out.println(isTreeSame(root1, root2));
    }

}