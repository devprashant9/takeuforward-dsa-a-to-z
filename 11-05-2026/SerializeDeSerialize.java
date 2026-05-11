import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerialize {

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

    public static String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                sb.append("#,");
                continue;
            }

            sb.append(curr.data).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    public static Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        String[] nodes = data.split(",");
        Node root = new Node(Integer.parseInt(nodes[0]));

        int i = 1;
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (i < nodes.length && !nodes[i].equals("#")) {
                Node left = new Node(Integer.parseInt(nodes[i]));
                curr.left = left;
                q.add(left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("#")) {
                Node right = new Node(Integer.parseInt(nodes[i]));
                curr.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.print("Original Tree: ");
        inOrder(root);
        System.out.println();

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        Node deserialized = deserialize(serialized);
        System.out.print("Tree after deserialization: ");
        inOrder(deserialized);
        System.out.println();
    }

}