import java.util.ArrayList;
import java.util.List;

public class InOrder {

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

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        helper(root.left, ans);

        ans.add(root.data);

        helper(root.right, ans);
    }
}