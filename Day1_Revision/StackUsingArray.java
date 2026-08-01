package Day1_Revision;

import java.util.Arrays;

public class StackUsingArray {
    private int[] st;
    private int top;

    StackUsingArray(int n) {
        st = new int[n];
        top = -1;
    }

    private void insert(int num) {
        if (top == st.length - 1) {
            throw new Error("Stack Overflow");
        }
        st[++top] = num;
    }

    private int delete() {
        if (empty()) {
            return -1;
        }
        int num = topElement();
        top--;
        return num;
    }

    private int topElement() {
        if (empty()) {
            return -1;
        }
        return st[top];
    }

    private boolean empty() {
        return top == -1;
    }

    private void printStack() {
        System.out.println(Arrays.toString(st));
    }

    public static void main(String[] args) {
        StackUsingArray ob = new StackUsingArray(5);
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
