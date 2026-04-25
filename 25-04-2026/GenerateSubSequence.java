public class GenerateSubSequence {

    public static void printSubSequence(String s, int i, String ans) {
        if (i == s.length()) {
            System.out.println(ans);
            return;
        }

        ans = ans + s.charAt(i);
        printSubSequence(s, i + 1, ans);
        ans = ans.substring(0, ans.length() - 1);
        printSubSequence(s, i + 1, ans);
    }

    public static int helper(int[] nums, int i, int k, int sum) {
        if (i == nums.length) {
            if (sum == k) {
                return 1;

            }
            return 0;
        }

        return helper(nums, i + 1, k, sum + nums[i]) + helper(nums, i + 1, k, sum);
    }

    public static void main(String[] args) {
        String s = "abc";
        printSubSequence(s, 0, "");

        System.out.println(helper(new int[] { 9, 9, 2, 5, 1 }, 0, 10, 0));
        ;
    }
}