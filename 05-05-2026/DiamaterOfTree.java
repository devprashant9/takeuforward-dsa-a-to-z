public class DiamaterOfTree {

    static int maxDiameter = 0;

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

    // Diameter of Tree Brute O(n^2)
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        // calculate each side height
        int leftHeight = helperHeight(root.left);
        int rightHeight = helperHeight(root.right);

        // diamater includes current node as well
        int throughNode = leftHeight + rightHeight + 1;
        maxDiameter = Math.max(maxDiameter, throughNode);

        // process first then go in depth
        // if processed before then we can do nothing we return value
        diameterOfTree(root.left);
        diameterOfTree(root.right);

        return maxDiameter;
    }

    // calculat height
    public static int helperHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(helperHeight(root.left), helperHeight(root.right));
    }

    // Diamater of Tree Optimized
    public static int diameterOptimized(Node root) {
        int[] ans = new int[1];

        optimizedHelper(root, ans);
        return ans[0];
    }

    public static int optimizedHelper(Node root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int leftHeight = optimizedHelper(root.left, ans);
        int rightHeight = optimizedHelper(root.right, ans);

        ans[0] = Math.max(ans[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Diamater of Tree -> Brute
        System.out.println(diameterOfTree(root));

        // Diameter of Tree -> Optimal
        System.out.println(diameterOptimized(root));
    }

}