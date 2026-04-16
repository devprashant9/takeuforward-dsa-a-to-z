public class CircularSinglyLL {

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
            nNode.next = head;
            return head;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = nNode;
        nNode.next = head;
        head = nNode;

        return head;
    }

    public static Node insertAtTail(int data, Node head) {
        if (head == null) {
            return insertAtHead(data, head);
        }

        Node nNode = new Node(data);
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        nNode.next = temp.next;
        temp.next = nNode;

        return head;
    }

    public static Node insertAtIndex(int data, Node head, int index) {
        if (index < 0 || head == null) {
            return head;
        }

        if (index == 0) {
            return insertAtHead(data, head);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp.next == head) {
                return head;
            }
            temp = temp.next;
        }

        Node nNode = new Node(data);
        nNode.next = temp.next;
        temp.next = nNode;

        return head;
    };

    public static Node deleteAtHead(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;

        return head;
    }

    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        Node deletedNode = temp.next;
        temp.next = head;
        deletedNode.next = null;

        return head;
    }

    public static Node deleteAtIndex(Node head, int index) {
        if (index < 0 || head == null) {
            return head;
        }

        if (index == 0) {
            return deleteAtHead(head);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp.next == head) {
                return head;
            }
            temp = temp.next;
        }

        Node deleteNode = temp.next;
        temp.next = deleteNode.next;
        deleteNode.next = null;

        return head;
    }

    public static Node deleteAtValue(Node head, int data) {
        if (head == null || (head.next == head && head.data == data)) {
            return null;
        }

        if (head.data == data) {
            return deleteAtHead(head);
        }

        Node temp = head;
        do {
            if (temp.next.data == data) {
                Node deleteNode = temp.next;
                temp.next = deleteNode.next;
                deleteNode.next = null;
                return head;
            }
            temp = temp.next;
        } while (temp != head);

        return head;
    }

    public static boolean searchLinkedList(Node head, int data) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        do {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    public static void printLinkedList(Node head) {
        if (head == null)
            return;

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(10, head);
        head = insertAtHead(20, head);
        head = insertAtHead(30, head);
        head = insertAtHead(40, head);
        head = insertAtTail(50, head);
        head = insertAtIndex(60, head, 2);
        printLinkedList(head);

        System.out.println();

        System.out.println("60 is Present in LinkedList: " + searchLinkedList(head, 60));
        System.out.println("90 is Present in LinkedList: " + searchLinkedList(head, 90));

        System.out.println();

        head = deleteAtHead(head);
        head = deleteAtTail(head);
        head = deleteAtIndex(head, 2);
        head = deleteAtValue(head, 60);
        printLinkedList(head);

    }
}
