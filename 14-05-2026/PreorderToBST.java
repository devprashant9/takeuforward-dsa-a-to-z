import java.util.Stack;

public class PreorderToBST {

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

    public static Node preOrderToBST(int[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);

        st.add(root);
        for (int i = 1; i < arr.length; i++) {
            Node top = st.peek();
            Node newNode = new Node(arr[i]);

            while (!st.isEmpty() && st.peek().data < arr[i]) {
                top = st.pop();
            }

            if (top.data < arr[i]) {
                top.right = newNode;
            } else {
                top.left = newNode;
            }

            st.push(newNode);
        }
        return root;
    }
}