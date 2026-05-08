import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {

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
        Node two = new Node(30);
        root.left = one;
        root.right = two;

        Node three = new Node(40);
        Node four = new Node(50);
        Node five = new Node(60);
        Node nine = new Node(100);

        one.left = three;
        one.right = four;

        two.left = five;
        two.right = nine;

        Node six = new Node(70);
        Node seven = new Node(80);
        Node eight = new Node(90);

        three.left = six;
        three.right = seven;

        four.left = eight;

        return root;
    }

    public static List<List<Integer>> rootToLeafPaths(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, new ArrayList<>(), ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> ans, List<List<Integer>> store) {
        ans.add(root.data);

        if (root.left == null && root.right == null) {
            store.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
            return;
        }

        if (root.left != null) {
            helper(root.left, ans, store);
        }

        if (root.right != null) {
            helper(root.right, ans, store);
        }

        ans.remove(ans.size() - 1);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // All Root to Leaf Path
        System.out.println(rootToLeafPaths(root));
    }
}