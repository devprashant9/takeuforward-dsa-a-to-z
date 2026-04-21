public class DeleteKey {

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

    public Node deleteAllOccurrences(Node head, int target) {

        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;

            if (temp.data == target) {

                if (temp.prev == null) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }

            }

            temp = nextNode;
        }
        return head;
    }
}