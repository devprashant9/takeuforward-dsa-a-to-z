import java.util.Stack;

public class SumOfSubarrayRanges {

    public static long sumSubarrayRanges(int[] nums) {
        long maxSum = sumSubarrayMax(nums);
        long minSum = sumSubarrayMin(nums);
        return maxSum - minSum;
    }

    public static long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallerElement(arr);
        int[] psee = previousSmallerEqualElement(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            long freq = left * right;
            sum += freq * arr[i];
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

    public static long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] nge = nextGreaterElement(arr);
        int[] pgee = previousGreaterEqualElement(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            long freq = left * right;
            sum += freq * arr[i];
        }
        return sum;
    }

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] previousGreaterEqualElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("Sum of Subarray Ranges: " + sumSubarrayRanges(nums));
    }
}