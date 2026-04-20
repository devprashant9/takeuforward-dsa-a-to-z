public class IntersectionPoint {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node curr1 = headA;
        Node curr2 = headB;
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;

            if (curr1 == curr2) {
                return curr1;
            }

            if (curr1 == null) {
                curr1 = headB;
            }

            if (curr2 == null) {
                curr2 = headA;
            }
        }

        return curr2;
    }
}