public class StringToInteger {

    public static int stringToInteger(String s) {
        int sLen = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if ((i == 0 && ch == '-') || Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        String s = "-12345 with words";
        System.out.println("The Integer Value of String is: " + stringToInteger(s));
    }
}
