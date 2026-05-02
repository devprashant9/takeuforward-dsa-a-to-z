import java.util.ArrayList;
import java.util.List;

public class PreOrder {

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

        ans.add(root.data);

        helper(root.left, ans);
        helper(root.right, ans);
    }
}