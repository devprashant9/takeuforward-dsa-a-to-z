package Day2_Revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementII {

    private static List<Integer> nextGreaterElement(int[] arr) {
        int n = arr.length;
        int lastIndex = 2 * n - 1;
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for (int i = lastIndex; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek());
                }
            }

            st.push(arr[i % n]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9 };
        System.out.println(nextGreaterElement(arr));
    }
}