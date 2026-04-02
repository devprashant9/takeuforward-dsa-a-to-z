import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            int num = nums[idx];

            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }

            // only insert if index is valid
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(num);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9 };
        System.out.println("Next Greater Elements Are: ");
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}