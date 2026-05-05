public class CheckBalancedBinaryTree {

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

    // Check Balanced Binary, Brute Force TC O(n^2)
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        // subtree should be valid
        boolean leftSubTree = isBalanced(root.left);
        boolean rightSubTree = isBalanced(root.right);

        // validity at each subtree level
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // everything should ve valid
        return leftSubTree && rightSubTree && Math.abs(leftHeight - rightHeight) <= 1;
    }

    // helper to find height
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // recursive o(n) solution
    public static boolean isBalancedOptimized(Node root) {
        return optimizedHelper(root) != -1;
    }

    // optimized helper i.e. calculate height even if imbalance
    public static int optimizedHelper(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = optimizedHelper(root.left);
        int rightHeight = optimizedHelper(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Brute Solution O(n^2)
        System.out.println(isBalanced(root));

        // Optimal Solution O(n)
        System.out.println(isBalancedOptimized(root));
    }

}