import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversal {

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

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    // Iterative Solution for All In One
    public static List<List<Integer>> allInOneIterative(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair top = st.pop();

            // STATE 1 → we have just "entered" the recursive call
            if (top.state == 1) {
                preorder.add(top.node.data); // preorder moment (before going left)

                top.state++; // next time we see this node → state 2
                st.push(top); // push back to resume after left subtree

                // simulate recursive call: visit(node.left)
                if (top.node.left != null)
                    st.push(new Pair(top.node.left, 1));
            }

            // STATE 2 → left subtree has finished
            else if (top.state == 2) {
                inorder.add(top.node.data); // inorder moment (after left, before right)

                top.state++; // next time → state 3
                st.push(top); // push back to resume after right subtree

                // simulate recursive call: visit(node.right)
                if (top.node.right != null)
                    st.push(new Pair(top.node.right, 1));
            }

            // STATE 3 → both left and right are done
            else {
                postorder.add(top.node.data); // postorder moment (before returning)
                // do nothing → recursive call finishes (do not push back)
            }
        }

        ans.add(preorder);
        ans.add(inorder);
        ans.add(postorder);

        return ans;
    }

    // All in One Traversal Using Recursion
    public static List<List<Integer>> allInOneRecursive(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        helper(root, inorder, preorder, postorder);
        ans.add(preorder);
        ans.add(inorder);
        ans.add(postorder);
        return ans;
    }

    public static void helper(Node root, List<Integer> inorder, List<Integer> preorder, List<Integer> postorder) {
        if (root == null) {
            return;
        }

        preorder.add(root.data);
        helper(root.left, inorder, preorder, postorder);
        inorder.add(root.data);
        helper(root.right, inorder, preorder, postorder);
        postorder.add(root.data);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Iterative Solution Answer
        System.out.println(allInOneIterative(root));

        // Recursive SOlution Answer
        System.out.println(allInOneRecursive(root));

    }

}