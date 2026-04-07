import java.util.Stack;

public class StringTest2 {

    public static int minimumAddition(String s) {
        int sLen = s.length();
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) {
                    cnt++;
                } else {
                    char data = st.peek();
                    if ((ch == ')' && data == '(') || (ch == '}' && data == '{') || (ch == ']' && data == '[')) {
                        st.pop();
                    }
                }
            }
        }
        return cnt + st.size();
    }

    public static void main(String[] args) {
        String s = "()))((()())(";
        System.out.println(minimumAddition(s));
    }
}
