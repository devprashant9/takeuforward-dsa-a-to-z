import java.util.ArrayList;
import java.util.List;

public class StackUsingArrays {

    List<Integer> st;
    int top;

    StackUsingArrays() {
        this.st = new ArrayList<>();
        this.top = -1;
    }

    public void push(int x) {
        this.st.add(x);
        this.top++;
    }

    public int pop() {
        if (this.st.isEmpty()) {
            return -1;
        }
        int data = this.top();
        this.st.remove(top);
        this.top--;
        return data;
    }

    public int top() {
        return this.st.get(top);
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StackUsingArrays st = new StackUsingArrays();
        System.out.println(st.isEmpty()); // true
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.isEmpty()); // false
        System.out.println(st.pop()); // 30
        System.out.println(st.top()); // 20
    }

}
