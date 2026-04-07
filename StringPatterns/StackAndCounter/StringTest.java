import java.util.Stack;

public class StringTest {

    public static boolean validBrackets(String s) {
        int sLen = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                char data = st.pop();
                if ((ch == ')' && data != '(') || (ch == '}' && data != '{') || (ch == ']' && data != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "a+(b*c)-{d/e+[f-(g+h)]}+[(i+j)*k]";
        System.out.println(validBrackets(s));
    }
}

// only operate on those characters which matters
// when last character needs to be worked first use Stack