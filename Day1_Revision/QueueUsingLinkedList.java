package Day1_Revision;

public class QueueUsingLinkedList {

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    private Node head;
    private Node rear;

    QueueUsingLinkedList() {
        head = null;
        rear = null;
    }

    private void insert(int num) {
        Node newNode = new Node(num);

        if (rear == null) {
            rear = newNode;
            head = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    private int delete() {
        if (empty()) {
            return -1;
        }

        int num = topElement();
        if (head == rear) {
            head = rear = null;
        } else {
            head = head.next;
        }

        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }

        return head.data;
    }

    private boolean empty() {
        return head == null;
    }

    private void printQueue() {
        Node curr = head;
        if (empty()) {
            System.out.println("EMPTY");
        } else {
            while (curr != null) {
                System.out.print(curr.data + " ->");
                curr = curr.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList ob = new QueueUsingLinkedList();
        ob.printQueue();
        System.out.println(ob.empty());

        ob.insert(10);
        ob.insert(20);
        ob.insert(30);
        ob.insert(40);
        ob.insert(50);
        ob.insert(60);
        ob.printQueue();

        System.out.println(ob.delete());
        ob.printQueue();

        System.out.println(ob.topElement());
    }

}