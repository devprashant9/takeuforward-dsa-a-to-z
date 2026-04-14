public class SinglyLL {

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

    public static Node insertAtTail(int data, Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node nNode = new Node(data);
        temp.next = nNode;

        return head;
    }

    public static Node insertAtIndex(int data, Node head, int index) {
        if (index < 0) {
            return head;
        }

        if (index == 0) {
            return insertAtHead(data, head);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node nNode = new Node(data);
        if (temp.next == null) {
            temp.next = nNode;
        }

        nNode.next = temp.next;
        temp.next = nNode;

        return head;
    }

    public static Node deleteAtHead(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteAtTail(Node head) {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static Node deleteAtIndex(int index, Node head) {
        if (index < 0) {
            return null;
        }

        if (index == 0) {
            return deleteAtHead(head);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node nextNode = temp.next.next;
        temp.next = nextNode;
        return head;
    }

    public static Node deleteAtValue(int data, Node head) {
        if (head != null && head.data == data) {
            return head = head.next;
        }

        Node temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.next != null && temp.next.data == data) {
                Node nextNode = temp.next.next;
                temp.next = nextNode;
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (!flag) {
            System.out.println("Data Not Found");
            return head;
        }

        return head;
    }

    public static boolean searchInList(Node head, int data) {
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

        head = insertAtHead(10, head);
        head = insertAtHead(20, head);
        head = insertAtHead(30, head);
        head = insertAtTail(40, head);
        head = insertAtTail(50, head);
        head = insertAtTail(60, head);
        head = insertAtIndex(70, head, 0);
        printLinkedList(head);

        System.out.println();

        System.out.println("Element 70 is Present in Linked List: " +searchInList(head, 70));
        System.out.println("Element 90 is Present in Linked List: " +searchInList(head, 90));

        head = deleteAtHead(head);
        head = deleteAtTail(head);
        head = deleteAtIndex(0, head);
        head = deleteAtValue(20, head);
        printLinkedList(head);
    }
}