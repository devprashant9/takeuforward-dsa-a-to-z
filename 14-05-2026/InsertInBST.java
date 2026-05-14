public class InsertInBST {

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

    public static Node insertNode(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            return newNode;
        }

        Node curr = root;
        while (true) {
            if (data < curr.data) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }
}