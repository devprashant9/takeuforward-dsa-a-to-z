import java.util.Arrays;

public class MinMaxBST {

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

    public static Node buildBST(Node root) {
        Node n1 = new Node(50);
        Node n2 = new Node(40);
        Node n3 = new Node(60);

        root = n1;
        n1.left = n2;
        n1.right = n3;

        Node n4 = new Node(35);
        Node n5 = new Node(45);
        n2.left = n4;
        n2.right = n5;

        Node n6 = new Node(55);
        Node n7 = new Node(65);
        n3.left = n6;
        n3.right = n7;

        Node n8 = new Node(46);
        Node n9 = new Node(47);
        n5.right = n8;
        n8.right = n9;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildBST(root);
        preOrder(root);

        System.out.println();
        int[] arr = new int[2];
        arr[0] = Integer.MAX_VALUE; // min
        arr[1] = Integer.MIN_VALUE; // max
        findMinMax(root, arr);
        System.out.println("Min & Max in BST is: " + Arrays.toString(arr));
    }

    public static void findMinMax(Node root, int[] ans) {
        if (root == null) {
            return;
        }

        ans[0] = Math.min(ans[0], root.data);
        ans[1] = Math.max(ans[1], root.data);

        findMinMax(root.left, ans);
        findMinMax(root.right, ans);
    }

}