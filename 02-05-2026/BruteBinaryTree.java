public class BruteBinaryTree {

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

    public static Node createRoot(int data, Node root) {
        if (root == null) {
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }
        return root;
    }

    public static Node insertLeftChild(int data, Node root) {
        if (root.left == null) {
            Node newNode = new Node(data);
            root.left = newNode;
            return root;
        }
        Node leftLeafNode = insertLeftChild(data, root.left);
        return leftLeafNode;
    }

    public static Node insertRightChild(int data, Node root) {
        if (root.right == null) {
            Node newNode = new Node(data);
            root.right = newNode;
            return root;
        }
        Node rightLeafNode = insertRightChild(data, root.right);
        return rightLeafNode;
    }

    public static void printBinaryTree(Node root) {
        if (root == null) {
            return;
        }

        printBinaryTree(root.left);
        System.out.println(root.data);
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        root = createRoot(10, root);

        root = insertLeftChild(20, root);
        root = insertRightChild(30, root);
        printBinaryTree(root);

    }
}