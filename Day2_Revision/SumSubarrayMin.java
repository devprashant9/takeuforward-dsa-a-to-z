package Day2_Revision;

import java.util.Arrays;
import java.util.Stack;

public class SumSubarrayMin {

    private static int[] nextSmallerElement(int[] arr, int n) {
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

    private static int[] previousSmallerElement(int[] arr, int n) {
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

    private static int sumOfSubarrayMin(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallerElement(arr, n);
        int[] pse = previousSmallerElement(arr, n);

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            int freq = left * right;
            int val = freq * arr[i];
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5 };
        System.out.println(sumOfSubarrayMin(arr));
    }

}