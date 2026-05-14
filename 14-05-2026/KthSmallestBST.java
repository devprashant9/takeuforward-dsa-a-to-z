public class KthSmallestBST {

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

    public static void kthSmallestHelper(Node root, int k) {
        if (root == null || cnt >= k) {
            return;
        }

        kthSmallestHelper(root.left, k);
        cnt++;
        if (cnt == k) {
            answer = root.data;
            return;
        }
        kthSmallestHelper(root.right, k);
    }

    public static int kthSmallest(Node root, int k) {
        kthSmallest(root, k);
        return answer;
    }
}