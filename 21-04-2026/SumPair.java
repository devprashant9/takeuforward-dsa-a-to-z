import java.util.ArrayList;
import java.util.List;

public class SumPair {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    public List<List<Integer>> findPairsWithGivenSum(Node head, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (head == null) {
            return ans;
        }

        Node tail = tailNode(head);

        Node first = head;
        Node last = tail;

        while (first != null && last != null && first != last && last.next != first) {
            int sum = first.data + last.data;

            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(first.data);
                list.add(last.data);

                ans.add(list);

                last = last.prev;
                first = first.next;
            } else if (sum > target) {
                last = last.prev;
            } else {
                first = first.next;
            }
        }

        return ans;
    }

    public static Node tailNode(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}