import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleHistogramArea(int[] nums) {
        int n = nums.length;
        int area = 0;
        int maxArea = 0;
        int nextSmallerElement = 0;
        int previousSmallerElement = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                int idx = st.pop();

                previousSmallerElement = st.isEmpty() ? -1 : st.peek();
                nextSmallerElement = i;

                area = nums[idx] * (nextSmallerElement - previousSmallerElement - 1);
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int idx = st.pop();

            previousSmallerElement = st.isEmpty() ? -1 : st.peek();
            nextSmallerElement = n;

            area = nums[idx] * (nextSmallerElement - previousSmallerElement - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Largest Rectangle Area of Histogram is: " + largestRectangleHistogramArea(nums));
    }
}