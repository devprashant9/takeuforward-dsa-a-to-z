import java.util.PriorityQueue;

public class KthLargest {

    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40, 50 };
        int k = 2;
        System.out.println("Kth Largest Element is: " + kthLargest(nums, k));
    }
}