import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CountSort {

    public static int[] countSort(int[] nums) {
        int max = maximumArrayElement(nums);
        Map<Integer, Integer> frequency = frequencyMap(nums);

        int[] answer = new int[nums.length];
        int index = 0;

        for (int i = 0; i <= max; i++) {
            int count = frequency.getOrDefault(i, 0);

            while (count > 0) {
                answer[index++] = i;
                count--;
            }
        }
        return answer;
    }

    public static int maximumArrayElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static Map<Integer, Integer> frequencyMap(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        return mp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 3, 2, 1, 0 };
        int[] sortedArray = countSort(nums);
        System.out.println("Sorted Array is: ");
        System.out.println(Arrays.toString(sortedArray));
    }
}

// TC: maximum + frequency + copying until Max Length = O(N) + O(N) + O(K);
// SC: O(N)

// Non-comparison sorting algorithm
// Stable (if cumulative frequency method is used)
// Works best with many repeated values
// Inefficient when range (K) is very large
// Commonly used in Radix Sort
// Requires extra memory (not in-place normally)