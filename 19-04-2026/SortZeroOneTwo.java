public class SortZeroOneTwo {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middleNode = findMiddlNode(head);

        Node left = head;
        Node right = middleNode.next;
        middleNode.next = null;

        left = sortLinkedList(left);
        right = sortLinkedList(right);

        return mergeLinkedLists(left, right);
    }

    public static Node findMiddlNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeLinkedLists(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        return dummyNode.next;
    }
}