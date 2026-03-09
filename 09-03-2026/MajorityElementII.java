import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static List<Integer> majorityElementTwo(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = 0, ele2 = 0;
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

        for (int num : nums) {
            if (num == ele1)
                cnt1++;
            else if (num == ele2)
                cnt2++;
        }

        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        if (cnt1 > n / 3)
            list.add(ele1);
        if (cnt2 > n / 3)
            list.add(ele2);

        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 3, 2, 2 };
        System.out.println("Majority Element in Array is: ");
        System.out.println(majorityElementTwo(nums));
    }
}