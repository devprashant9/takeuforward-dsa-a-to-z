import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            pq.add(m);
        }

        int j = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> curr = pq.poll();
            for (int i = 0; i < curr.getValue(); i++) {
                nums[j++] = curr.getKey();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 5, 2, 1, 3, 2 };
        System.out.println("Sorted Array is: " + Arrays.toString(frequencySort(nums)));
    }
}