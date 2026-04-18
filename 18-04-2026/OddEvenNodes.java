public class OddEvenNodes {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;

        ListNode evenHead = evenNode;

        while (evenNode != null && evenNode.next != null) {
            // link next odd
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            // link next even
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;

        return head;
    }
}