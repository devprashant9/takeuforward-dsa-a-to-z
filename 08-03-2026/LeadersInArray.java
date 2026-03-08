import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {

    public static List<Integer> leadersInArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 40, 50, 30 };
        System.out.println("Leaders in Array are: " + Arrays.toString(nums));
        System.out.println(leadersInArray(nums));
    }
}