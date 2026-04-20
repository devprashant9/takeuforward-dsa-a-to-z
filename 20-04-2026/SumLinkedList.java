public class SumLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        Node temp1 = l1;
        Node temp2 = l2;

        Node dummyNode = new Node(-1);
        Node dummyHead = dummyNode;

        int carry = 0;
        while (temp1 != null || temp2 != null || carry != 0) {
            int val1 = (temp1 != null) ? temp1.data : 0;
            int val2 = (temp2 != null) ? temp2.data : 0;
            int sum = val1 + val2 + carry;

            dummyHead.next = new Node(sum % 10);
            dummyHead = dummyHead.next;

            carry = sum / 10;

            if (temp1 != null) {
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }

        return dummyNode.next;
    }
}