import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrays {

    List<Integer> q;
    int front;
    int rear;

    QueueUsingArrays() {
        this.q = new ArrayList<>();
        this.front = -1;
        this.rear = -1;
    }

    // assuming front to be the 0th index and rear to be size-1th Index
    public void push(int x) {
        if (isEmpty()) {
            q.add(x);
            front = 0;
            rear = 0;
            return;
        }
        q.add(x);
        rear++;
    }

    public int pop() {
        if (isEmpty())
            return -1;

        int data = q.get(front);
        q.remove(front);
        rear--;
        if (rear < 0) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return q.get(front);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        QueueUsingArrays q = new QueueUsingArrays();
        System.out.println(q.isEmpty()); // true
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        System.out.println(q.isEmpty()); // false
        System.out.println(q.pop()); // 10
        System.out.println(q.peek()); // 20
    }
}