public class RotateLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = findLength(head);
        k = k % length;

        if (k == 0) {
            return head;
        }

        int leftSteps = length - k;

        Node kthNode = findKthNode(head, leftSteps);
        Node nextNode = kthNode.next;

        kthNode.next = null;

        Node curr = nextNode;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        return nextNode;
    }

    public static int findLength(Node head) {
        if (head == null) {
            return 0;
        }

        if (head.next == null) {
            return 1;
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static Node findKthNode(Node head, int k) {
        Node temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }
}