import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestK {

    static class Pair {
        int absDifference;
        int num;

        Pair(int absDifference, int num) {
            this.absDifference = absDifference;
            this.num = num;
        }
    }

    public static int[] kClosestNumber(int[] nums, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.absDifference - a.absDifference);

        for (int num : nums) {
            pq.add(new Pair(Math.abs(num - x), num));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        for (Pair p : pq) {
            ans[i++] = p.num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 6, 7, 8, 9 };
        int k = 3;
        int x = 7;
        System.out.println("K Closes Number in Array is: " + Arrays.toString(kClosestNumber(nums, k, x)));
    }
}