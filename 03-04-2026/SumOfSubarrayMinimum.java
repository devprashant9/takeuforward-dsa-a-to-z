import java.util.Stack;

public class SumOfSubarrayMinimum {

    public static int sumSubarrayMin(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallerElement(arr);
        int[] psee = previousSmallerEqualElement(arr);
        int sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }

    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] previousSmallerEqualElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5 };
        System.out.println("Sum of Aubarray Minimums Are: " + sumSubarrayMin(nums));
    }
}