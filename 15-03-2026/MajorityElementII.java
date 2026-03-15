import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {

    public static List<Integer> majorityElementII(int[] nums) {
        int ele1 = 0, ele2 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                cnt2++;
            } else if (nums[i] == ele1) {
                cnt1++;
            } else if (nums[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (num == ele1)
                cnt1++;
            else if (num == ele2)
                cnt2++;
        }

        if (cnt1 > nums.length / 3)
            ans.add(ele1);
        if (cnt2 > nums.length / 3)
            ans.add(ele2);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 2, 1, 3, 3, 4 };
        System.out.println("Majority Element in Array is: " + Arrays.toString(nums));
        System.out.println(majorityElementII(nums));
    }
}