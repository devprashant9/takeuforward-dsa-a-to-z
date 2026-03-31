import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    int min;

    MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (isEmpty()) {
            st.push(x);
            min = x;
            return;
        }
        if (x >= min) {
            st.push(x);
        } else {
            st.push(2 * x - min);
            min = x;
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        int top = st.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int getMin() {
        return min;
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public int peek() {
        if (isEmpty())
            return -1;

        int top = st.peek();
        if (top < min) {
            return min;
        }
        return top;
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        System.out.println(st.isEmpty());
        st.push(10);
        st.push(30);
        st.push(20);
        st.push(40);
        System.out.println(st.isEmpty());
        System.out.println(st.peek());
        st.pop();
    }

}