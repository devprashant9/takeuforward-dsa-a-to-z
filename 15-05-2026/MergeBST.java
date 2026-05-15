import java.util.Stack;

public class MergeBST {

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

    static Stack<Node> st = new Stack<>();

    public MergeBST(Node root) {
        pushAll(root);
    }

    public static boolean hasNext() {
        return !st.isEmpty();
    }

    public static int next() {
        Node temp = st.pop();
        pushAll(temp.right);
        return temp.data;
    }

    public static void pushAll(Node root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}