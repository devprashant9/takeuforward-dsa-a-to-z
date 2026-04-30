import java.util.List;
import java.util.ArrayList;

class ExpressionOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, "", 0, 0, result);
        return result;
    }

    private static void backtrack(String num, int target, int index, String expr, long currentValue, long lastValue,
            List<String> result) {

        // reached end of string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // avoid numbers like "05"
            if (i != index && num.charAt(index) == '0')
                break;

            String part = num.substring(index, i + 1);
            long number = Long.parseLong(part);

            // first number (no operator before it)
            if (index == 0) {
                backtrack(num, target, i + 1, part, number, number, result);
            } else {
                // +
                backtrack(num, target, i + 1,
                        expr + "+" + part,
                        currentValue + number,
                        number,
                        result);

                // -
                backtrack(num, target, i + 1,
                        expr + "-" + part,
                        currentValue - number,
                        -number,
                        result);

                // *
                backtrack(num, target, i + 1,
                        expr + "*" + part,
                        currentValue - lastValue + lastValue * number,
                        lastValue * number,
                        result);
            }
        }
    }

    public static void main(String[] args) {
        String s = "123";
        int target = 6;
        System.out.println(addOperators(s, target));
    }
}