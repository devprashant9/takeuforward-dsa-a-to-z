package Day1_Revision;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    QueueUsingStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    private void insert(int num) {
        st1.push(num);
    }

    private int delete() {
        if (empty()) {
            return -1;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    private boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    private void printQueue() {
        System.out.println(st1);
    }

    public static void main(String[] args) {
        QueueUsingStack ob = new QueueUsingStack();
        ob.printQueue();
        System.out.println(ob.empty());

        ob.insert(10);
        ob.insert(20);
        ob.insert(30);
        ob.insert(40);
        ob.insert(50);
        ob.insert(60);
        ob.printQueue();

        System.out.println(ob.delete());
        ob.printQueue();

        System.out.println(ob.topElement());
    }

}