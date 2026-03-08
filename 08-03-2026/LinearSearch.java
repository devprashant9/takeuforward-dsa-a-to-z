
public class LinearSearch {

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40 };
        int target = 40;
        System.out.println("Element is Prsent in Array at Position: " + target);
        System.out.println(linearSearch(nums, target));
    }
}