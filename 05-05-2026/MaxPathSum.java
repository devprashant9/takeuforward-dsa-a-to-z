public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

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

    // Max Sum Brute
    public static int maxSumPath(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = bruteHelper(root.left);
        int rightSum = bruteHelper(root.right);

        maxSum = Math.max(maxSum, leftSum + rightSum + root.data);

        maxSumPath(root.left);
        maxSumPath(root.right);

        return maxSum;
    }

    // brute helper
    public static int bruteHelper(Node root) {
        if (root == null) {
            return 0;
        }

        int left = bruteHelper(root.left);
        int right = bruteHelper(root.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        return root.data + Math.max(left, right);
    }

    // Max Sum Optimized
    public static int maxSumOptimized(Node root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        optimizedHelper(root, ans);
        return ans[0];
    }

    // Optimized Helper
    public static int optimizedHelper(Node root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left = optimizedHelper(root.left, ans);
        int right = optimizedHelper(root.right, ans);

        // calculate max gains
        left = Math.max(0, left);
        right = Math.max(0, right);

        // sum values with current node & find max
        ans[0] = Math.max(ans[0], left + right + root.data);

        return root.data + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // MaxSum Path Optimal
        System.out.println(maxSumPath(root));

        // MaxSum Path Optimal
        System.out.println(maxSumOptimized(root));

    }

}