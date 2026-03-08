import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] nums) {
        int longestSequence = 0;
        Set<Integer> st = new HashSet<>();

        for (int num : nums) {
            st.add(num);
        }

        for (int num : st) {
            if (!st.contains(num - 1)) {
                int sequence = 0;
                while (st.contains(num)) {
                    sequence += 1;
                    num += 1;
                }
                longestSequence = Math.max(sequence, longestSequence);
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest Consecutive Sequence in Array is: " + Arrays.toString(nums));
        System.out.println(longestConsecutiveSequence(nums));
    }
}