import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpiralTraversal {

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

    // Spiral Traversal Optimal Use ArrayDeque
    public static List<List<Integer>> spiralTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();

            Deque<Integer> deq = new ArrayDeque<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

                if (flag) {
                    deq.addFirst(curr.data);
                } else {
                    deq.addLast(curr.data);
                }

            }
            ans.add(new ArrayList<>(deq));
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Spiral Traversal Optimized
        System.out.println(spiralTraversal(root));
    }
}