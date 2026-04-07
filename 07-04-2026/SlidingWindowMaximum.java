import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] slidingWindowMax(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;

        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.peekFirst() <= (i - k)) {
                deq.pollFirst();
            }

            while (!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]) {
                deq.pollLast();
            }

            deq.offerLast(i);

            if (i >= (k - 1)) {
                ans[ansIndex++] = nums[deq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k = 3;
        System.out.println("Sliding Window Maximum For Array is: ");
        System.out.println(Arrays.toString(slidingWindowMax(num, k)));
    }
}