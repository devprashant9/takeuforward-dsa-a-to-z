import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class BSTIterator {
    Stack<Node> st = new Stack<>();
    boolean reverse;

    public BSTIterator(Node root, boolean isReverse) {
        pushAll(root);
        reverse = isReverse;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        Node temp = st.pop();

        if (reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }

        return temp.data;
    }

    public void pushAll(Node root) {
        while (root != null) {
            st.push(root);
            root = reverse ? root.left : root.right;
        }
    }
}

public class TwoSumBST {

    public static boolean twoSum(Node root, int data) {
        BSTIterator left = new BSTIterator(root, true);
        BSTIterator right = new BSTIterator(root, false);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j < data) {
                i = left.next();
            } else if (i + j > data) {
                j = right.next();
            } else {
                return true;
            }
        }
        return false;
    }
}