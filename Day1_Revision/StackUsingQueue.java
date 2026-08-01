package Day1_Revision;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q;

    StackUsingQueue() {
        q = new LinkedList<>();
    }

    private void insert(int num) {
        q.offer(num);

        int len = q.size();
        for (int i = 0; i < len - 1; i++) {
            q.add(q.remove());
        }
    }

    private int delete() {
        if (empty()) {
            return -1;
        }
        return q.remove();
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }
        return q.peek();
    }

    private boolean empty() {
        return q.isEmpty();
    }

    private void printStack() {
        System.out.println(q);
    }

    public static void main(String[] args) {
        StackUsingQueue ob = new StackUsingQueue();
        ob.printStack();
        System.out.println(ob.empty());

        ob.insert(10);
        ob.insert(20);
        ob.insert(30);
        ob.insert(40);
        ob.insert(50);
        ob.printStack();

        System.out.println(ob.delete());
        ob.printStack();

        System.out.println(ob.topElement());
    }

}