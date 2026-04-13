import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequent {

    public static List<Integer> topFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet()); // Map cannot be directly sorted
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).getKey());
        }

        return ans;
    }

    public static int[] optimalSolution(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            pq.add(m);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 2, 2, 4 };
        int k = 2;
        System.out.println("Top Frequent Element Are: " + Arrays.toString(optimalSolution(nums, k)));
    }
}
