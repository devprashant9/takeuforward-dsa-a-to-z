import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 8, 0, 1, 3 };
        System.out.println("Next Greater Elements Are: ");
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}