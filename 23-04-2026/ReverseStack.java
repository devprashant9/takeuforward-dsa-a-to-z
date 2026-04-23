import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack(st);
        pushToBottom(st, top);
    }

    public static void pushToBottom(Stack<Integer> st, int ele) {
        if (st.isEmpty()) {
            st.push(ele);
            return;
        }

        int top = st.pop();
        pushToBottom(st, ele);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 10; i <= 50; i += 10) {
            st.push(i);
        }

        System.out.println("Stack Before Reverse: " + st);
        reverseStack(st);
        System.out.println("Stack After Reverse: " + st);
    }
}