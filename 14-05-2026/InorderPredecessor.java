public class InorderPredecessor {

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

    public static int predecessor(Node root, int data) {
        int answer = -1;

        while (root != null) {
            if (root.data < data) {
                answer = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return answer;
    }
}