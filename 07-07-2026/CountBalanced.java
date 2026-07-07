import java.util.Stack;

class CountBalanced {
    public int countRev(String s) {
        int n = s.length();

        if ((n & 1) == 1)
            return -1;

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        int open = 0;
        int close = 0;

        while (!st.isEmpty()) {
            if (st.pop() == '(')
                open++;
            else
                close++;
        }

        return (open + 1) / 2 + (close + 1) / 2;
    }
}