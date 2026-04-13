import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSorted {

    public static int[] sortKSortedArray(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                nums[i++] = pq.peek();
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            nums[i++] = pq.poll();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;
        System.out.println("Sorted Array is: " + Arrays.toString(sortKSortedArray(nums, k)));
    }
}