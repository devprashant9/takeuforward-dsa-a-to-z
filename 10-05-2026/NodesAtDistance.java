import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesAtDistance {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
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

    public static List<Integer> nodesAtDistanceK(Node root, Node target, int k) {
        Map<Node, Node> mp = markParentPointers(root);
        List<Integer> list = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        int distance = 0;

        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            // invalidity check
            if (distance == k) {
                while (!q.isEmpty()) {
                    list.add(q.remove().data);
                }
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();

                // check left
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                // check right
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                // check parent
                if (mp.containsKey(curr) && !visited.contains(mp.get(curr))) {
                    q.add(mp.get(curr));
                    visited.add(mp.get(curr));
                }
            }
            distance++;
        }
        return list;
    }

    public static Node createTree(List<Integer> nodes, int index) {
        if (index < nodes.size() && nodes.get(index) != null) {
            Node root = new Node(nodes.get(index));
            root.left = createTree(nodes, 2 * index + 1);
            root.right = createTree(nodes, 2 * index + 2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> nodes = Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        Node root = createTree(nodes, 0);
        Node target = root.left;
        int k = 2;

        System.out.println(nodesAtDistanceK(root, target, k));
    }
}