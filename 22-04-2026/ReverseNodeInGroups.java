public class ReverseNodeInGroups {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1)
            return head;

        Node curr = head;
        Node prevGroupTail = null;

        while (curr != null) {
            // Step 1: Find kth node from current
            Node kthNode = getKthNode(curr, k);

            // Not enough nodes → attach remaining part and break
            if (kthNode == null) {
                if (prevGroupTail != null) {
                    prevGroupTail.next = curr;
                }
                break;
            }

            Node nextGroupHead = kthNode.next;

            // Step 2: Reverse current k-group
            reverseSegment(curr, kthNode);

            // Step 3: Connect previous group to this reversed group
            if (curr == head) {
                head = kthNode; // first group becomes new head
            } else {
                prevGroupTail.next = kthNode;
            }

            // Step 4: Connect tail of reversed group to next group
            curr.next = nextGroupHead;

            // Move pointers to next group
            prevGroupTail = curr;
            curr = nextGroupHead;
        }

        return head;
    }

    // Reverse linked list from start → end (inclusive)
    private void reverseSegment(Node start, Node end) {
        Node prev = null;
        Node curr = start;
        Node stop = end.next;

        while (curr != stop) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    // Returns kth node from given head (or null if not enough nodes)
    private Node getKthNode(Node head, int k) {
        while (head != null && --k > 0) {
            head = head.next;
        }
        return head;
    }
}