import java.util.Stack;

public class BalancedParentheses {

    public static boolean balancedParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                char topData = st.peek();
                if ((topData == '(' && ch != ')') || (topData == '{' && ch != '}') || (topData == '[' && ch != ']')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]{}({[]})";
        System.out.println("The Given String is Balanced Parentheses? " + balancedParentheses(s));
    }
}