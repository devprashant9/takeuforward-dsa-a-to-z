public class LoopSizeInLL {

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

    public static Node createLoopedLinnkedList(Node head) {
        Node fifthNode = null;
        Node temp = head;
        int i = 1;
        while (temp.next != null) {
            temp = temp.next;
            if (i == 5) {
                fifthNode = temp;
            }
            i++;
        }
        temp.next = fifthNode;
        return head;
    }

    public static int loopSize(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int size = 1;
                while (slow.next != fast) {
                    slow = slow.next;
                    size++;
                }
                return size;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 90; i >= 10; i -= 10) {
            head = insertAtHead(i, head);
        }

        head = createLoopedLinnkedList(head);

        System.out.println("Given Linked List Has Loop: " + loopSize(head));
    }
}