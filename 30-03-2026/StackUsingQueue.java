import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> st;

    public StackUsingQueue() {
        st = new LinkedList<>();
    }

    public void push(int x) {
        st.add(x);

        // reverse after each insertion
        int size = st.size();
        for (int i = 0; i < size - 1; i++) {
            st.add(st.remove());
        }
    }

    public int pop() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.remove();
    }

    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue st = new StackUsingQueue();
        System.out.println(st.isEmpty()); // true
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.isEmpty()); // false
        System.out.println(st.pop()); // 30
        System.out.println(st.top()); // 20
    }
}