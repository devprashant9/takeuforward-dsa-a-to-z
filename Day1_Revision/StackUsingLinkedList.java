package Day1_Revision;

public class StackUsingLinkedList {

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    StackUsingLinkedList() {
        head = null;
    }

    private void insert(int num) {
        Node newNode = new Node(num);
        if (empty()) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    private int delete() {
        if (empty()) {
            return -1;
        }

        int num = topElement();

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.data;
    }

    private boolean empty() {
        return head == null;
    }

    private void printStack() {
        Node curr = head;
        if (curr == null) {
            System.out.println("Empty");
            return;
        }

        while (curr != null) {
            curr = curr.next;
            System.out.print(curr.data + " ->");
        }
        System.out.print(" -> null");
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList ob = new StackUsingLinkedList();
        ob.printStack();
        System.out.println(ob.empty());

        ob.insert(10);
        ob.insert(20);
        ob.insert(30);
        ob.insert(40);
        ob.insert(50);
        ob.printStack();

        System.out.println(ob.delete());
        ob.printStack();

        System.out.println(ob.topElement());
    }
}
