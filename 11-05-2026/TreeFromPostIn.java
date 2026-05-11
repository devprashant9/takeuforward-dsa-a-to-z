import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFromPostIn {

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

    public static Map<Integer, Integer> createInOrderMapping(List<Integer> inOrder) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < inOrder.size(); i++) {
            mp.put(inOrder.get(i), i);
        }

        return mp;
    }

    public static Node buildTree(List<Integer> postOrder, int postStart, int postEnd, List<Integer> inOrder,
            int inStart,
            int inEnd, Map<Integer, Integer> mp) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(postOrder.get(postEnd));

        int inRoot = mp.get(root.data);
        int leftNums = inRoot - inStart;

        root.left = buildTree(postOrder, postStart, postStart + leftNums - 1, inOrder, inStart, inRoot - 1, mp);
        root.right = buildTree(postOrder, postStart + leftNums, postEnd - 1, inOrder, inRoot + 1, inEnd, mp);

        return root;
    }

    public static Node buildPostAndIn(List<Integer> postOrder, List<Integer> inOrder) {
        Map<Integer, Integer> mp = createInOrderMapping(inOrder);
        Node root = buildTree(postOrder, 0, postOrder.size() - 1, inOrder, 0, inOrder.size() - 1, mp);

        return root;
    }

    // PostOrder Traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // InOrder Traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        List<Integer> postOrder = Arrays.asList(9, 15, 7, 20, 3);
        List<Integer> inOrder = Arrays.asList(9, 3, 15, 20, 7);

        Node root = buildPostAndIn(postOrder, inOrder);
        postOrder(root);
        System.out.println();
        inOrder(root);
    }
}