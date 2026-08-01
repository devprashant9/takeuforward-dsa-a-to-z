package Day1_Revision;

import java.util.Arrays;

public class QueueUsingArray {

    private int[] q;
    private int front;
    private int rear;

    QueueUsingArray(int n) {
        q = new int[n];
        front = rear = -1;
    }

    private void insert(int num) {
        if (rear == q.length - 1) {
            throw new Error("Queue Overflow");
        }

        rear++;
        if (empty()) {
            q[rear] = num;
            front++;
        } else {
            q[rear] = num;
        }
    }

    private int delete() {
        if (empty()) {
            return -1;
        }

        int num = topElement();
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }

        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }
        return q[front];
    }

    private boolean empty() {
        return front == -1;
    }

    private void printQueue() {
        System.out.println(Arrays.toString(q));
    }

    public static void main(String[] args) {
        QueueUsingArray ob = new QueueUsingArray(6);
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