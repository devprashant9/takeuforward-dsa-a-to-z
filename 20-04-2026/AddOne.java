public class AddOne {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node addOne(Node head) {
        if (head == null) {
            return head;
        }

        Node reversedHead = reverseLinkedList(head);
        Node temp = reversedHead;

        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;

        int carry = 1;
        while (temp != null) {
            int sum = temp.data + carry;
            dummyHead.next = new Node(sum % 10);
            dummyHead = dummyHead.next;
            carry = sum / 10;

            temp = temp.next;
        }

        if (carry > 0) {
            dummyHead.next = new Node(carry);
        }

        return reverseLinkedList(dummyNode.next);
    }

    public static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node previous = null;

        while (curr != null) {
            Node nextNode = curr.next;

            curr.next = previous;

            previous = curr;
            curr = nextNode;
        }

        return previous;
    }
}