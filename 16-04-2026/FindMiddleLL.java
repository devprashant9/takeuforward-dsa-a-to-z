public class FindMiddleLL {

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

    public static Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        Node middle = findMiddle(head);
        System.out.println("Middle of Linked List is: " + middle.data);
    }
}