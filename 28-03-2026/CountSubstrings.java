public class CountSubstrings {

    public static int countSubstringSizeK(String s, int k) {
        int n = s.length();
        if (k > n)
            return 0;
        return n - k + 1;
    }

    public static void main(String[] args) {
        String s = "prashant";
        int k = 4;
        System.out.println("Number of Substring With Given Length is: " + countSubstringSizeK(s, k));
    }
}