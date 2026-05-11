import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFromPreIn {

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

    public static Node buildTree(List<Integer> preOrder, int preStart, int preEnd, List<Integer> inOrder, int inStart,
            int inEnd, Map<Integer, Integer> mp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(preOrder.get(preStart));

        int inRoot = mp.get(root.data);
        int leftNums = inRoot - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftNums, inOrder, inStart, inRoot - 1, mp);
        root.right = buildTree(preOrder, preStart + 1 + leftNums, preEnd, inOrder, inRoot + 1, inEnd, mp);

        return root;
    }

    public static Node buildPreAndIn(List<Integer> preOrder, List<Integer> inOrder) {
        Map<Integer, Integer> mp = createInOrderMapping(inOrder);
        Node root = buildTree(preOrder, 0, preOrder.size() - 1, inOrder, 0, inOrder.size() - 1, mp);

        return root;
    }

    // PreOrder Traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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
        List<Integer> preOrder = Arrays.asList(3, 9, 20, 15, 7);
        List<Integer> inOrder = Arrays.asList(9, 3, 15, 20, 7);

        Node root = buildPreAndIn(preOrder, inOrder);
        preOrder(root);
        System.out.println();
        inOrder(root);
    }

}