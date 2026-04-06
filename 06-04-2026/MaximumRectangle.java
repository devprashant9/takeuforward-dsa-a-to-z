import java.util.Stack;

public class MaximumRectangle {

    public static int maximumRectangle(int[][] nums) {
        columnPrefixSum(nums);
        int maxArea = 0;
        for (int i = 0; i < nums.length; i++) {
            int area = largestRectangleArea(nums[i]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void columnPrefixSum(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        for (int col = 0; col < cols; col++) {
            int sum = 0;

            for (int row = 0; row < rows; row++) {
                if (nums[row][col] == 0) {
                    sum = 0;
                } else {
                    sum += 1;
                }
                nums[row][col] = sum;
            }
        }
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int maxArea = 0;
        int previousSmallerElement = 0;
        int nextSmallerElement = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int idx = st.pop();

                previousSmallerElement = st.isEmpty() ? -1 : st.peek();
                nextSmallerElement = i;

                int area = heights[idx] * (nextSmallerElement - previousSmallerElement - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int idx = st.pop();

            previousSmallerElement = st.isEmpty() ? -1 : st.peek();
            nextSmallerElement = n;

            int area = heights[idx] * (nextSmallerElement - previousSmallerElement - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 }
        };
        System.out.println("Area of Maximum Rectangle is: " + maximumRectangle(nums));
    }
}