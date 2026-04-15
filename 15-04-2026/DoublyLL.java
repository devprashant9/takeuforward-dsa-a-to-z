public class DoublyLL {

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

    public static Node insertAtTail(int data, Node head) {
        if (head == null) {
            return insertAtHead(data, head);
        }

        Node nNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nNode;
        nNode.prev = temp;

        return head;
    }

    public static Node insertAtIndex(int data, Node head, int index) {
        if (index < 0) {
            return head;
        }

        if (index == 0) {
            return insertAtHead(data, head);
        }

        Node nNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node nextNode = temp.next;
        temp.next = nNode;
        nNode.prev = temp;
        nNode.next = nextNode;

        return head;
    }

    public static Node deleteAtHead(Node head) {
        if (head.next == null) {
            head = null;
            return head;
        }

        Node temp = head.next;
        head.next = null;
        temp.prev = null;
        head = temp;
        return head;
    }

    public static Node deleteAtTail(Node head) {
        if (head == null) {
            return head;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    public static Node deleteAtIndex(Node head, int index) {
        if (index < 0) {
            return head;
        }

        if (index == 0) {
            return deleteAtHead(head);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Needs to play around with 3 Node store them
        Node currentNode = temp;
        Node deletedNode = temp.next;
        Node nextNode = deletedNode.next;

        currentNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = currentNode;
        }

        deletedNode.prev = null;
        deletedNode.next = null;

        return head;
    }

    public static Node deleteAtValue(Node head, int data) {
        if (head != null && head.data == data) {
            return deleteAtHead(head);
        }

        Node temp = head;
        Node prevNode = null;
        Node nextNode = null;
        boolean flag = false;
        while (temp != null) {
            if (temp.data == data) {
                prevNode = temp.prev;
                nextNode = temp.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("Key Not Present");
            return head;
        }

        prevNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }

        temp.prev = null;
        temp.next = null;

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

    public static boolean searchLinkedList(Node head, int data) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static Node reverseDoubleLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node forward = current.next;

            current.next = previous;
            current.prev = forward;

            previous = current;
            current = forward;
        }
        return previous;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtHead(10, head);
        head = insertAtHead(20, head);
        head = insertAtHead(30, head);
        head = insertAtTail(40, head);
        head = insertAtTail(50, head);
        head = insertAtIndex(60, head, 0);
        printLinkedList(head);

        System.out.println();

        System.out.println("The Key 30 is Present in LinkedList: " + searchLinkedList(head, 30));
        System.out.println("The Key 90 is Present in LinkedList: " + searchLinkedList(head, 90));

        head = deleteAtHead(head);
        head = deleteAtTail(head);
        head = deleteAtIndex(head, 3);
        head = deleteAtValue(head, 20);
        printLinkedList(head);
    }
}