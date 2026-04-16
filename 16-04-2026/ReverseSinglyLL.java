public class ReverseSinglyLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertAtHead(int data, Node head) {
        Node nNode = new Node(data);
        if (head == null) {
            head = nNode;
        } else {
            nNode.next = head;
            head = nNode;
        }
        return head;
    }

    public static Node reverseSinglyLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

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

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 90; i >= 10; i -= 10) {
            head = insertAtHead(i, head);
        }
        printLinkedList(head);
        System.out.println();

        System.out.println("Reversed Linked List is: ");
        head = reverseSinglyLL(head);
        printLinkedList(head);
    }
}