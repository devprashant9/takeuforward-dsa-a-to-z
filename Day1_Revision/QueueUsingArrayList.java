package Day1_Revision;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList {

    private List<Integer> q;
    private int front;
    private int rear;

    QueueUsingArrayList() {
        q = new ArrayList<>();
        front = rear = -1;
    }

    private void insert(int num) {
        if (rear == -1) {
            rear++;
            front++;
        } else {
            rear++;
        }
        q.add(num);
    }

    private int delete() {
        if (empty()) {
            return -1;
        }

        int num = topElement();
        if (front == rear) {
            front = rear = -1;
            q.clear();
        }
        front++;

        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }
        return q.get(front);
    }

    private boolean empty() {
        return q.isEmpty();
    }

    private void printQueue() {
        System.out.println(q);
    }

    public static void main(String[] args) {
        QueueUsingArrayList ob = new QueueUsingArrayList();
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