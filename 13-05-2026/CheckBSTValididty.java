public class CheckBSTValididty {

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

    public static void main(String[] args) {
        Node root = null;
        root = buildBST(root);
        System.out.println(isBSTValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isBSTValid(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isBSTValid(root.left, min, root.data) && isBSTValid(root.right, root.data, max);
    }
}