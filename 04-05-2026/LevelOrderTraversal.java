import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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

    // LevelOrder Iterative
    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                list.add(curr.data);
            }

            ans.add(list);
        }
        return ans;
    }

    // LevelOrder Recursive
    public static List<Integer> leverOrderRecursive(Node root) {
        List<Integer> ans = new ArrayList<>();
        int height = heightOfTree(root);
        for (int i = 1; i <= height; i++) {
            printLevelOrderTraversal(root, i, ans);
        }
        return ans;
    }

    public static void printLevelOrderTraversal(Node root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            ans.add(root.data);
        } else {
            printLevelOrderTraversal(root.left, level - 1, ans);
            printLevelOrderTraversal(root.right, level - 1, ans);
        }

    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Iterative Solution Answer
        System.out.println(levelOrderTraversal(root));

        // Recursive Solution Answer
        System.out.println(leverOrderRecursive(root));
        ;
    }

}