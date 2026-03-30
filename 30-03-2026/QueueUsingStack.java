import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (isEmpty())
            return -1;

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (isEmpty())
            return -1;

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop()); // 10
        System.out.println(q.peek()); // 20
    }
}