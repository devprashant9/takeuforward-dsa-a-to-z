public class CircularDoublyLL {

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
            head.next = head;
            head.prev = head;
            return head;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        nNode.prev = temp;
        nNode.next = head;
        temp.next = nNode;
        head = nNode;

        return head;
    }

    public static Node insertAtTail(int data, Node head) {
        if (head == null) {
            return head;
        }

        Node nNode = new Node(data);

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        nNode.next = head;
        nNode.prev = temp;
        temp.next = nNode;

        return head;
    }

    public static Node insertAtIndex(int data, Node head, int index) {
        if (index < 0) {
            return head;
        }

        if (head == null) {
            if (index == 0) {
                return insertAtHead(data, head);
            }
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

        Node nextNode = temp.next;
        nextNode.prev = nNode;
        nNode.next = nextNode;
        nNode.prev = temp;
        temp.next = nNode;

        return head;
    }

    public static Node deleteAtHead(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        Node newHead = head.next;
        temp.next = newHead;
        newHead.prev = temp;

        head.prev = null;
        head.next = null;

        head = newHead;

        return head;
        // since we have tail reference we can do it in O(1)
    }

    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == head) {
            return null;
        }

        Node secondLastNode = head.prev.prev;

        Node deletedNode = head.prev;
        deletedNode.prev = null;
        deletedNode.next = null;

        secondLastNode.next = head;
        head.prev = secondLastNode;

        return head;
    }

    public static Node deleteAtIndex(Node head, int index) {
        if (head == null || index < 0) {
            return null;
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
        deleteNode.next.prev = temp;

        deleteNode.next = null;
        deleteNode.prev = null;

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
                deleteNode.next.prev = temp;
                deleteNode.next = null;
                deleteNode.prev = null;
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
    };

    public static void printLinkedList(Node head) {
        Node temp = head;
        do {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        } while (temp != head);
        System.out.print("(back to head)");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(10, head);
        head = insertAtHead(20, head);
        head = insertAtHead(30, head);
        head = insertAtHead(40, head);
        head = insertAtTail(50, head);
        head = insertAtTail(60, head);
        head = insertAtIndex(70, head, 7);
        printLinkedList(head);

        System.out.println();

        System.out.println("60 is Present in LinkedList: " + searchLinkedList(head, 60));
        System.out.println("90 is Present in LinkedList: " + searchLinkedList(head, 90));

        System.out.println();

        head = deleteAtHead(head);
        head = deleteAtTail(head);
        head = deleteAtIndex(head, 1);
        head = deleteAtValue(head, 10);
        printLinkedList(head);
    }
}