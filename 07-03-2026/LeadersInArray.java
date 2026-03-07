import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LeadersInArray {

    public static List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int max = nums[nums.length - 1];
        list.add(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                list.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(list);
        return list;
    }
}