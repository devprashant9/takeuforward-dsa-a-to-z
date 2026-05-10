public class ChildrenSum {

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
        Node n1 = new Node(40);
        Node n2 = new Node(10);
        Node n3 = new Node(20);

        Node n4 = new Node(2);
        Node n5 = new Node(5);

        Node n6 = new Node(30);
        Node n7 = new Node(40);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        root = n1;
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

    // check children sum
    public static boolean isValid(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;

        return (root.data == left + right) && isValid(root.left) && isValid(root.left);
    }

    // brute - may not work
    public static boolean solve(Node root) {
        if (root == null) {
            return true;
        }

        for (int i = -1000; i <= 1000; i++) {
            int original = root.data;
            root.data = i;
            if (isValid(root) && solve(root.left) && solve(root.right)) {
                return true;
            }
            root.data = original;
        }
        return false;
    }

    // optimal
    public static void childrenSum(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        int left = (root.left != null) ? root.left.data : 0;
        int right = (root.right != null) ? root.right.data : 0;

        int sum = left + right;

        // if children sum is smaller, push parent value down
        if (sum < root.data) {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }

        childrenSum(root.left);
        childrenSum(root.right);

        left = (root.left != null) ? root.left.data : 0;
        right = (root.right != null) ? root.right.data : 0;

        root.data = left + right;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        childrenSum(root);

        preOrder(root);
    }
}