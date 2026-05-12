public class TreeToLinkedList {

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

    private static Node prev = null;

    public static void treeToLinkedList(Node root) {
        if (root == null) {
            return;
        }

        treeToLinkedList(root.right);
        treeToLinkedList(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void printLinkedList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
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
        root = buildTree(root);
        preOrder(root);
        System.out.println();

        treeToLinkedList(root);
        printLinkedList(root);
    }

}