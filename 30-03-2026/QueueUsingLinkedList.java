import java.util.LinkedList;

public class QueueUsingLinkedList {

    LinkedList<Integer> q;

    public QueueUsingLinkedList() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.addFirst(x);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return q.removeLast();
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return q.getLast();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        System.out.println(q.isEmpty()); // true
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        System.out.println(q.isEmpty()); // false
        System.out.println(q.pop()); // 10
        System.out.println(q.top()); // 20
    }
}