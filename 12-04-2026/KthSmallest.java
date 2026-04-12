import java.util.PriorityQueue;

public class KthSmallest {

    public static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

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
        System.out.println("Kth Smallest Element is: " + kthSmallest(nums, k));
    }
}