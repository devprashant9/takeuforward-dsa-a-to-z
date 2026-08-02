package Day2_Revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    private static List<Integer> nextGreaterElement(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peek());

            st.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 0, 8, 1, 3 };
        System.out.println(nextGreaterElement(arr));
    }
}