import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int longestSequence = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }

        for (int num : st) {
            if (!st.contains(num - 1)) {
                int count = 1;
                int starting = num;

                while (st.contains(starting + 1)) {
                    count += 1;
                    starting += 1;
                }

                longestSequence = Math.max(longestSequence, count);
            }
        }
        return longestSequence;
    }
}