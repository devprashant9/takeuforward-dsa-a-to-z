import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        int sLen = nums.length();

        for (int i = 0; i < sLen; i++) {
            char ch = nums.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() - '0' > ch - '0') {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder("");
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.reverse();

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "541892";
        int k = 2;
        System.out.println("Smallest Possible Integer After Removing K Digits is: " + removeKdigits(s, k));
    }
}