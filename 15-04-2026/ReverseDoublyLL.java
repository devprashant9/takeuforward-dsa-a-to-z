
public class ReverseDoublyLL {

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

    public static Node insertAtHead(int data, Node head) {
        Node nNode = new Node(data);
        if (head == null) {
            head = nNode;
        } else {
            head.prev = nNode;
            nNode.next = head;
            head = nNode;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node reverseDoublyLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node nextNode = current.next;

            current.next = previous;
            current.prev = nextNode;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 90; i >= 10; i -= 10) {
            head = insertAtHead(i, head);
        }
        printLinkedList(head);
        System.out.println();
        head = reverseDoublyLL(head);
        printLinkedList(head);
    }
}
