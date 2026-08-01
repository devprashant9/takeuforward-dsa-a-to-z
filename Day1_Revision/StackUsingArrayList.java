package Day1_Revision;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    private List<Integer> st;
    private int top;

    StackUsingArrayList() {
        st = new ArrayList<>();
        top = -1;
    }

    private void insert(int num) {
        st.add(num);
        top++;
    }

    private int delete() {
        if (empty()) {
            return -1;
        }
        int num = topElement();
        st.remove(top);
        top--;
        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }
        return st.get(top);
    }

    private boolean empty() {
        return top == -1;
    }

    private void printStack() {
        System.out.println(st);
    }

    public static void main(String[] args) {
        StackUsingArrayList ob = new StackUsingArrayList();
        ob.printStack();
        System.out.println(ob.empty());

        ob.insert(10);
        ob.insert(20);
        ob.insert(30);
        ob.insert(40);
        ob.insert(50);
        ob.printStack();

        System.out.println(ob.delete());
        ob.printStack();

        System.out.println(ob.topElement());
    }
}
