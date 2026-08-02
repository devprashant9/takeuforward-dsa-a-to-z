package Day2_Revision;

import java.util.Stack;

public class SumSubarrayRanges {

    private static int sumSubarrayRange(int[] arr) {
        int n = arr.length;

        int minSum = sumSubarrayMin(arr, n);
        int maxSum = subSubarrayMax(arr, n);
        return maxSum - minSum;
    }

    private static int sumSubarrayMin(int[] arr, int n) {
        int[] psee = previousSmallerEqualElement(arr, n);
        int[] nse = nextSmallerElement(arr, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            int val = left * right;
            sum += val * arr[i];
        }
        return sum;
    }

    private static int[] previousSmallerEqualElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int subSubarrayMax(int[] arr, int n) {
        int[] pgee = previousGreaterEqualElement(arr, n);
        int[] nge = nextGreaterElement(arr, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;

            int val = left * right;
            sum += val * arr[i];
        }
        return sum;
    }

    private static int[] previousGreaterEqualElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5 };
        System.out.println(sumSubarrayRange(arr));
    }
}