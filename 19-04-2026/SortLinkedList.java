public class SortLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node sortZeroOneTwo(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);

        Node temp = head;
        Node zeroHead = dummyZero;
        Node oneHead = dummyOne;
        Node twoHead = dummyTwo;

        while (temp != null) {
            if (temp.data == 0) {
                zeroHead.next = temp;
                zeroHead = temp;
            } else if (temp.data == 1) {
                oneHead.next = temp;
                oneHead = temp;
            } else {
                twoHead.next = temp;
                twoHead = temp;
            }
            temp = temp.next;
        }

        zeroHead.next = dummyOne.next != null ? dummyOne.next : dummyTwo.next;
        oneHead.next = dummyTwo.next;
        twoHead.next = null;

        return dummyZero.next;
    }
}