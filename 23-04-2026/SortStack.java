import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        rearrangeStack(st, top);
    }

    public static void rearrangeStack(Stack<Integer> st, int ele) {
        if (st.isEmpty() || ele <= st.peek()) {
            st.push(ele);
            return;
        }

        int top = st.pop();
        rearrangeStack(st, ele);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 10; i <= 50; i += 10) {
            st.push(i);
        }

        System.out.println("Stack Before Reverse: " + st);
        sortStack(st);
        System.out.println("Stack After Reverse: " + st);
    }
}