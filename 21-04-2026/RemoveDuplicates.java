public class RemoveDuplicates {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    public Node removeDuplicates(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        while (curr != null) {

            Node temp = curr;
            while (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            }

            curr.next = temp.next;

            if (temp.next != null) {
                temp.next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}