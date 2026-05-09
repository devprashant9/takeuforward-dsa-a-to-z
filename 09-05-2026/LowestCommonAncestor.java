import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

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
        Node n1 = new Node(30);
        Node n2 = new Node(50);
        Node n3 = new Node(10);
        Node n4 = new Node(60);
        Node n5 = new Node(20);
        Node n6 = new Node(90);
        Node n7 = new Node(80);
        Node n8 = new Node(70);
        Node n9 = new Node(40);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.left = n8;
        n5.right = n9;

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

    // brute techique
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        List<Node> pList = new ArrayList<>();
        List<Node> qList = new ArrayList<>();

        rootToLeafPath(root, p, pList);
        rootToLeafPath(root, q, qList);

        Node ans = null;
        int minSize = Math.min(pList.size(), qList.size());
        for (int i = 0; i < minSize; i++) {
            if (pList.get(i) == qList.get(i)) {
                ans = pList.get(i);
            }
        }
        return ans;

    }

    public static boolean rootToLeafPath(Node root, Node a, List<Node> ans) {
        if (root == null) {
            return false;
        }

        ans.add(root);

        if (root == a) {
            return true;
        }

        if (rootToLeafPath(root.left, a, ans)) {
            return true;
        }

        if (rootToLeafPath(root.right, a, ans)) {
            return true;
        }

        ans.remove(ans.size() - 1);
        return false;
    }

    // optimal technique
    public static Node lowestCommonAncestorOptimal(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Brute Force
        System.out.println(lowestCommonAncestor(root, root.left.right.left, root.left).data);

        // Optimal Solution
        System.out.println(lowestCommonAncestorOptimal(root, root.left.right.left, root.left).data);

    }
}