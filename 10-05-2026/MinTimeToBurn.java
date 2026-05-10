import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinTimeToBurn {

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

    public static Map<Node, Node> markParentPointers(Node root) {
        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr.left != null) {
                mp.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                mp.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return mp;
    }

    public static Node findStartNode(Node root, int start) {
        if (root == null)
            return null;

        if (root.data == start)
            return root;

        Node left = findStartNode(root.left, start);
        if (left != null)
            return left;

        Node right = findStartNode(root.right, start);
        if (right != null)
            return right;

        return null;
    }

    public static int timeToBurnTree(Node root, int start) {
        Node startNode = findStartNode(root, start);
        Map<Node, Node> mp = markParentPointers(root);
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        int time = 0;

        q.add(startNode);
        visited.add(startNode);
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                if (curr.left != null && !visited.contains(curr.left)) {
                    flag = 1;
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    flag = 1;
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                if (mp.containsKey(curr) && !visited.contains(mp.get(curr))) {
                    flag = 1;
                    q.add(mp.get(curr));
                    visited.add(mp.get(curr));
                }
            }

            if (flag == 1) {
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(40);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(timeToBurnTree(root, 40));
        ;
    }
}