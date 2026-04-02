import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreaterElementToRight {

    public static List<Integer> greaterOnRight(int[] nums, int[] idx) {

        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    cnt++;
                }
            }
            mp.put(i, cnt);
        }

        List<Integer> ans = new ArrayList<>();
        n = idx.length;
        for (int i = 0; i < n; i++) {
            ans.add(mp.get(idx[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int[] idx = { 0, 5 };
        System.out.println("Greater Element to Right For Given Indices Are: " + Arrays.toString(idx));
        System.out.println(greaterOnRight(nums, idx));
    }
}