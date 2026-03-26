public class LargestOddNumberString {

    public static String largestOddNumber(String s) {
        int n = s.length();

        int end = -1;
        for (int i = n - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                end = i;
                break;
            }
        }

        if (end == -1) {
            return "";
        }

        int start = 0;
        while (start < n && (s.charAt(start) - '0') == 0) {
            start++;
        }

        if (start > n) {
            return "";
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "00246819";
        System.out.println("Maximum Odd Number in String is: " + largestOddNumber(s));
    }
}