import java.util.*;

public class ReplaceElementByRank {

    static class Pair {
        int idx;
        int num;

        Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static int[] replaceElement(int[] nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(i, nums[i]));
        }

        int rank = 1;
        int prev = Integer.MIN_VALUE;
        int[] ans = new int[nums.length];

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.num != prev) {
                prev = cur.num;
                ans[cur.idx] = rank;
                rank++;
            } else {
                ans[cur.idx] = rank - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 20, 15, 26, 2, 98, 6 };
        System.out.println(Arrays.toString(replaceElement(nums)));
    }
}