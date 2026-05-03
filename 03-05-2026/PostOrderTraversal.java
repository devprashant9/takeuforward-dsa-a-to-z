import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

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

    // PostOrder Iterative 2 Stack
    public static List<Integer> postOrder2Stack(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            st2.push(curr);

            if (curr.left != null)
                st1.push(curr.left);
            if (curr.right != null)
                st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }

        return ans;
    }

    // PostOrder Iterative 1 Stack + Reverse
    public static List<Integer> postOrder1STackReverse(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if (root != null) {
            st.push(root);
        }

        // Until the stack is empty
        while (!st.isEmpty()) {
            Node node = st.pop(); // get the top node

            ans.add(node.data); // add it to the list

            // Add its left child if it exists
            if (node.left != null)
                st.push(node.left);

            // Add its right child if it exists
            if (node.right != null)
                st.push(node.right);
        }

        Collections.reverse(ans);

        return ans;
    }

    // PostOrder Iterative 1 Stack + lastVisited
    public static List<Integer> postOrder1Stack(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        Node curr = root;
        Node lastVisited = null;

        while (curr != null || !st.isEmpty()) {

            // Step 1: go left as much as possible
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = st.peek();

                // Step 2: if right subtree exists and NOT processed -> go right
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                }
                // Step 3: otherwise process node
                else {
                    ans.add(peekNode.data);
                    lastVisited = st.pop();
                }
            }
        }
        return ans;
    }

    // PostOrder Recursive
    public static List<Integer> postOrderRecursive(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public static void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.data);
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Iterative Solution Answer Using 2 Stack
        System.out.println(postOrder2Stack(root));

        // Iterative Solution Answer Using 1 Stack + Reverse Trick
        System.out.println(postOrder1STackReverse(root));

        // Iterative Solution Answer Using 1 Stack + lastVisited
        System.out.println(postOrder1Stack(root));

        // Recursive SOlution Answer
        System.out.println(postOrderRecursive(root));
    }

}