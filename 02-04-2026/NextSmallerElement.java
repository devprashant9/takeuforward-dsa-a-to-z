import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 8, 5, 2, 25 };
        System.out.println("Next Smaller Elements Are: ");
        System.out.println(Arrays.toString(nextSmallerElements(nums)));
    }
}