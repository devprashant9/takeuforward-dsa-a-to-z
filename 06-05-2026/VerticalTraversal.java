import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {

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

    // Vertical Traversal Left-Right
    // Each Vertical Printed From Top To Bottom
    // Key Idea => Think Trees Being Represented in 2D View
    // TreeMap => AutoSorts The Keys as we need elements in a sorted order
    static class Tuple {
        Node node;
        int x;
        int y;

        Tuple(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }

    }

    public static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> constructGraph(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tup = q.remove();

            // get all data from current tuple
            Node curr = tup.node; // node
            int x = tup.x; // vertical
            int y = tup.y; // level

            // first "vertical" needs to be the key
            nodesMap.putIfAbsent(x, new TreeMap<>()); // vertical as key and value is TreeMap
            nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>()); // inner TreeMap needs to have "level" as key
            nodesMap.get(x).get(y).add(curr.data); // data needs to be added in sorted order

            // add left child
            if (curr.left != null) {
                q.add(new Tuple(curr.left, x - 1, y + 1)); // when moving left
            }

            // add right child
            if (curr.right != null) {
                q.add(new Tuple(curr.right, x + 1, y + 1)); // when moving right
            }

        }
        return nodesMap;
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = constructGraph(root);
        List<List<Integer>> ans = new ArrayList<>();

        // extract each vertical
        for (TreeMap<Integer, PriorityQueue<Integer>> val : nodesMap.values()) {

            // to store answer at each level of each vertical
            List<Integer> currentLevel = new ArrayList<>();

            // get level at current vertical
            for (PriorityQueue<Integer> pq : val.values()) {
                while (!pq.isEmpty()) {
                    currentLevel.add(pq.remove());
                }
            }

            // add to main ans
            ans.add(currentLevel);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        root = buildTree(root);

        // Vertical traversal
        System.out.println(verticalTraversal(root));
    }
}