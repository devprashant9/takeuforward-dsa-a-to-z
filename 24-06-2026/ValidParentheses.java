import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "*(())(*";

        System.out.println(recursive(s, 0, 0));
        System.out.println(stackSolution(s));
        System.out.println(optimal(s));
    }

    private static boolean recursive(String str, int i, int balance) {
        if (balance < 0)
            return false;
        if (i == str.length())
            return balance == 0;

        if (str.charAt(i) == '(')
            return recursive(str, i + 1, balance + 1);
        if (str.charAt(i) == ')')
            return recursive(str, i + 1, balance - 1);
        return recursive(str, i + 1, balance + 1) ||
                recursive(str, i + 1, balance - 1) ||
                recursive(str, i + 1, balance);
    }

    private static boolean stackSolution(String str) {
        Stack<Integer> parentheses = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();

        int sLen = str.length();

        // Prcessing
        for (int i = 0; i < sLen; i++) {
            char ch = str.charAt(i);
            if (ch == '(')
                parentheses.push(i);
            else if (ch == '*')
                asterisk.push(i);
            else {
                if (!parentheses.isEmpty())
                    parentheses.pop();
                else if (!asterisk.isEmpty())
                    asterisk.pop();
                else
                    return false;
            }
        }

        // Post Processing
        while (!parentheses.isEmpty() && !asterisk.isEmpty()) {
            if (asterisk.peek() < parentheses.peek())
                return false;
            parentheses.pop();
            asterisk.pop();
        }

        return parentheses.isEmpty();
    }

    private static boolean optimal(String str) {
        int sLen = str.length();

        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < sLen; i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else if (ch == '*') {
                minOpen--;
                maxOpen++;
            }

            if (minOpen < 0)
                minOpen = 0;
            if (maxOpen < 0)
                return false;
        }

        return minOpen == 0;
    }
}