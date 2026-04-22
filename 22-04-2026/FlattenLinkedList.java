public class FlattenLinkedList {

    static class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public Node flattenLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;

        // Flatten the list on right side first
        head.next = flattenLinkedList(head.next);

        // Merge current vertical list with right flattened list
        head = merge(head, head.next);

        return head;
    }

    // Merge two sorted linked lists using CHILD pointer
    private Node merge(Node a, Node b) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }

        // Attach remaining nodes
        if (a != null)
            temp.child = a;
        else
            temp.child = b;

        return dummy.child;
    }
}