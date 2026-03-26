public class RemoveParentheses {

    public static String removeOuterMostParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    sb.append(c);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "()(())(())";
        System.out.println("After Removing Outermost Parentheses the String is: " + removeOuterMostParentheses(s));
    }
}