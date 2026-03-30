import java.util.LinkedList;

public class StackUsingLinkedList {

    LinkedList<Integer> st;

    public StackUsingLinkedList() {
        st = new LinkedList<>();
    }

    public void push(int x) {
        st.addLast(x);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return st.removeLast();
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return st.getLast();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingLinkedList st = new StackUsingLinkedList();
        System.out.println(st.isEmpty()); // true
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.isEmpty()); // false
        System.out.println(st.pop()); // 30
        System.out.println(st.top()); // 20
    }
}