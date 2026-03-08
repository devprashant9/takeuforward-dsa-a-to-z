import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {

    public static int[] countSort(int[] nums) {
        Map<Integer, Integer> hashedArray = hashArray(nums);
        int maxElement = findMaximum(nums);
        int[] answer = copyElements(maxElement, nums.length, hashedArray);
        return answer;
    }

    public static Map<Integer, Integer> hashArray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        return mp;
    }

    public static int findMaximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int[] copyElements(int max, int len, Map<Integer, Integer> mp) {
        int[] answerArray = new int[len];
        int j = 0;

        for (int i = 0; i <= max; i++) {
            int count = mp.getOrDefault(i, 0);
            for (int k = 0; k < count; k++) {
                answerArray[j++] = i;
            }
        }
        return answerArray;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 2, 2, 0, 1, 0, 1, 1, 3 };
        System.out.println(Arrays.toString(countSort(nums)));
    }
}