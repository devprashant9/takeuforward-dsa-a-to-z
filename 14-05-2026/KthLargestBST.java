public class KthLargestBST {

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

    static int cnt = 0;
    static int answer = -1;

    public static void kthLargestHelper(Node root, int k) {
        if (root == null || cnt >= k) {
            return;
        }

        kthLargestHelper(root.left, k);
        cnt++;
        if (cnt == k) {
            answer = root.data;
            return;
        }
        kthLargestHelper(root.right, k);
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int kthLargest(Node root, int k) {
        kthLargest(root, countNodes(root) - k + 1);
        return answer;
    }

}