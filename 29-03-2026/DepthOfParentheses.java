public class DepthOfParentheses {

    public static int maxDepth(String s) {
        int maxDepth = 0;
        int cnt = 0;
        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cnt++;
                maxDepth = Math.max(maxDepth, cnt);
            } else if (ch == ')') {
                cnt--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum Depth of String is: " + maxDepth(s));
    }
}
