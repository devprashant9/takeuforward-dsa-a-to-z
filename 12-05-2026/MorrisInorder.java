import java.util.ArrayList;
import java.util.List;

public class MorrisInorder {

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
        root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(15);
        root.right.right = new Node(25);

        return root;
    }

    public static List<Integer> morrisInorder(Node root) {
        List<Integer> list = new ArrayList<>();
        morrisInorderHelper(root, list);
        return list;
    }

    public static void morrisInorderHelper(Node root, List<Integer> ans) {
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            } else {
                Node temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);
        inOrder(root);
        System.out.println();
        System.out.println(morrisInorder(root));
    }

}