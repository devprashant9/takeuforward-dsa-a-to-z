public class DeleteInBST {

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

    public static Node deleteNode(Node root, int data) {
        if (root == null) {
            return root;
        }

        Node prev = null;
        Node curr = root;
        while (curr != null && curr.data != data) {
            prev = curr;
            if (data < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return deleteNode(root, prev, curr);
    }

    public static Node deleteNode(Node root, Node prev, Node curr) {

        // Case 1: Key Not Present
        if (curr == null) {
            return root;
        }

        // Case 2: Delete Leaf Node
        if (curr.left == null && curr.right == null) {
            if (prev == null) {
                return null;
            }

            if (prev.left == curr) {
                prev.left = null;
            } else {
                prev.right = null;
            }

            return root;
        }

        // Case 3: Node Has Left Child
        if (curr.right == null) {
            if (prev == null) {
                return curr.left;
            }

            if (prev.left == curr) {
                prev.left = curr.left;
            } else {
                prev.right = curr.left;
            }

            return root;
        }

        // Case 4: Node Has Right Child
        if (curr.left == null) {
            if (prev == null) {
                return curr.right;
            }

            if (prev.left == curr) {
                prev.left = curr.right;
            } else {
                prev.right = curr.right;
            }

            return root;
        }

        // Case 5: Node Has Left & Right Child
        // Here we Need InOrder Predecessor or InOrder Successor
        Node temp = curr.left;

        // find inorder predecessor (max in left subtree)
        Node parentOfTemp = curr;
        while (temp.right != null) {
            parentOfTemp = temp;
            temp = temp.right;
        }

        // replace value
        curr.data = temp.data;

        // delete temp node manually
        if (parentOfTemp == curr) {
            // predecessor is immediate left child
            parentOfTemp.left = temp.left;
        } else {
            // predecessor is deeper in right chain
            parentOfTemp.right = temp.left;
        }

        return root;
    }

    public static int inOrderPredecessor(Node root, int data) {
        int answer = -1;
        while (root != null) {
            if (root.data < data) {
                answer = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return answer;
    }
}