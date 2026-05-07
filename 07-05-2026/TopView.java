import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

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

    static class Tuple {
        Node node;
        int x;

        Tuple(Node node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public static List<Integer> constructGraph(Node root) {
        TreeMap<Integer, Node> nodesMap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0));
        while (!q.isEmpty()) {
            Tuple tup = q.remove();
            Node curr = tup.node;

            nodesMap.putIfAbsent(tup.x, curr);

            if (curr.left != null) {
                q.add(new Tuple(curr.left, tup.x - 1));
            }

            if (curr.right != null) {
                q.add(new Tuple(curr.right, tup.x + 1));
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Node mp : nodesMap.values()) {
            ans.add(mp.data);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Top View of Binary Tree is
        System.out.println(constructGraph(root));
    }

}