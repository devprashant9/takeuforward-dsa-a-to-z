public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 10, 20, 20, 30, 40 };
        System.out.println("Number of Unique Elements in Array is: ");
        System.out.println(removeDuplicates(nums));
    }
}