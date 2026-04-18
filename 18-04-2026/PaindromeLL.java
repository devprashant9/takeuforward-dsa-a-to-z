public class PaindromeLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public boolean isPalindrome(ListNode head) {

        ListNode middleNode = middleLinkedList(head);
        ListNode tailNode = reverseLinkedList(middleNode);

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val != tailNode.val) {
                return false;
            }
            temp = temp.next;
            tailNode = tailNode.next;
        }

        return true;
    }

    public static ListNode middleLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverseLinkedList(ListNode middleNode) {
        ListNode current = middleNode;
        ListNode previous = null;

        while (current != null) {
            ListNode nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }
}